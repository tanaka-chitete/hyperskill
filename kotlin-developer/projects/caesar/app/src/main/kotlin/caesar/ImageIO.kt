package caesar

import java.awt.Color
import java.io.File
import javax.imageio.ImageIO

class ImageIO {
    fun encrypt(inputFilename: String, outputFilename: String) {
        // Create a file instance in order to read the input file
        val inputFile = File(inputFilename)
        // Create a BufferedImage instance from the 24-bit image file data
        val inputImage = ImageIO.read(inputFile)

        println("Message to hide:")
        var message = readLine()!!.encodeToByteArray()

        println("Password:")
        val password = readLine()!!.encodeToByteArray()

        // Encrypt the message using the given the password
        message = PasswordIO().encrypt(message, password)

        if (!message.isEncryptableIn(inputImage)) {
            println("The input image is not large enough to hold this message.")
        } else {
            var numBitsEncrypted = 0
            outer@ for (y in 0 until inputImage.height) {
                for (x in 0 until inputImage.width) {
                    if (numBitsEncrypted == message.size * 8) {
                        break@outer
                    } else {
                        val color = Color(inputImage.getRGB(x, y))

                        val bitToEncrypt = message.getBitGiven(numBitsEncrypted)

                        // Set LSB of pixel's blue channel to previously obtained bit
                        val newColor = Color(color.red, color.green, color.blue.changeLastBitTo(bitToEncrypt))

                        inputImage.setRGB(x, y, newColor.rgb)

                        numBitsEncrypted++
                    }
                }
            }
            // Create a file instance in order to save the modified image
            val outputFile = File(outputFilename)
            // Create an image using the BufferedImage instance data
            ImageIO.write(inputImage, "png", outputFile)

            println("Message saved in $outputFilename image.")
        }
    }

    fun decrypt(inputFilename: String) {
        // Create a file instance in order to read the input file
        val inputFile = File(inputFilename)
        // Create a BufferedImage instance from the 24-bit image file data
        val inputImage = ImageIO.read(inputFile)

        println("Password:")
        val password = readLine()!!.encodeToByteArray()

        var numBitsDecrypted = 0
        var byte = 0
        var message = byteArrayOf()
        outer@ for (y in 0 until inputImage.height) {
            for (x in 0 until inputImage.width) {
                if (message.containsEOM()) {
                    break@outer
                } else {
                    val color = Color(inputImage.getRGB(x, y))

                    // Get LSB of pixel's blue channel
                    val bit = color.blue.bitAt(0)

                    // Set bit at bitIndex (from right) of byte to previously gotten bit
                    byte = byte.changeBitsGiven(numBitsDecrypted, bit)

                    numBitsDecrypted++

                    // Prepare to decode next bit from image if all bits of current byte have been decoded
                    if (numBitsDecrypted % 8 == 0) {
                        message += byte.toByte()
                        byte = 0
                    }
                }
            }
        }

        // Decrypt the message using the given the password
        message = PasswordIO().decrypt(message, password)

        // Convert message from ByteArray to String and print converted message to the terminal
        println("Message:\n" + message.toString(Charsets.UTF_8))
    }
}