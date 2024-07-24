package caesar

fun main() {
    do {
        println("Task (hide, show, exit):")
        val input = readLine()!!
        when (input) {
            "hide" -> Operations().hide()
            "show" -> Operations().show()
            "exit" -> Operations().exit()
            else -> println("Wrong task: $input")
        }
    } while (input != "exit")
}
