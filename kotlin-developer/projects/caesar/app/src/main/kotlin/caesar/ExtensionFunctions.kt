package caesar

import java.awt.image.BufferedImage

fun ByteArray.isEncryptableIn(image: BufferedImage): Boolean {
    return (this.size * 8) <= (image.height * image.width)
}

fun ByteArray.getBitGiven(numBitsEncrypted: Int): Int {
    val byteIndex = numBitsEncrypted / 8
    val bitIndex = numBitsEncrypted % 8
    val byte = this[byteIndex]
    val bit = byte.bitAt(7 - bitIndex) // 7 - n because of RTL ordering

    return bit
}

fun Int.changeBitsGiven(numBitsDecrypted: Int, bit: Int): Int {
    val bitIndex = numBitsDecrypted % 8
    val newByte = (bit shl (7 - bitIndex)) or this // 7 - n because of RTL ordering

    return newByte
}

fun Byte.bitAt(bitIndex: Int): Int {
    return (this.toInt() shr bitIndex) and 1
}

fun Int.changeLastBitTo(bit: Int): Int {
    return if (this % 2 == 0) {
        this or bit
    } else {
        this and (254 + bit)
    }
}

fun ByteArray.containsEOM(): Boolean {
    return this.size >= 3 &&
            this[this.lastIndex - 2] == 0.toByte() &&
            this[this.lastIndex - 1] == 0.toByte() &&
            this[this.lastIndex] == 3.toByte()
}

fun Int.bitAt(bitIndex: Int): Int {
    return (this shr bitIndex) and 1
}
