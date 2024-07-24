package caesar

import kotlin.experimental.xor

class PasswordIO {
    fun encrypt(plainMessage: ByteArray, password: ByteArray): ByteArray {
        var encryptedMessage = byteArrayOf()

        for (i in plainMessage.indices) {
            // Encrypt each byte of the message using the corresponding byte of the password
            // If the message is longer than the password, the bytes of the password are reused
            encryptedMessage += plainMessage[i] xor password[i % password.size]
        }

        // Append End of Message (EOM) characters
        encryptedMessage += byteArrayOf(0, 0, 3)

        return encryptedMessage
    }

    fun decrypt(encryptedMessage: ByteArray, password: ByteArray): ByteArray {
        val encryptedMessageCopy = encryptedMessage.copyOfRange(0, encryptedMessage.size - 3)

        var plainMessage = byteArrayOf()

        for (i in encryptedMessageCopy.indices) {
            // Decrypt each byte of the message using the corresponding byte of the password
            // If the message is longer than the password, the bytes of the password are reused
            plainMessage += encryptedMessageCopy[i] xor password[i % password.size]
        }

        return plainMessage
    }
}