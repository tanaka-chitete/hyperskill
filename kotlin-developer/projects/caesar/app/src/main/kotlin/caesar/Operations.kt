package caesar

import java.io.IOException

class Operations {
    fun hide() {
        println("Input image file:")
        val inputFilename = readLine()!!

        println("Output image file:")
        val outputFilename = readLine()!!

        try {
            ImageIO().encrypt(inputFilename, outputFilename)
        } catch (e: IOException) {
            println("Can't read input file!")
        }
    }

    fun show() {
        println("Input image file:")
        val inputFilename = readLine()!!

        try {
            ImageIO().decrypt(inputFilename)
        } catch (e: IOException) {
            println("Can't read input file!")
        }
    }

    fun exit() {
        println("Bye!")
    }
}