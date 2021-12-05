package day2

import loadInput

fun main() {
    val commands = loadInput("02.txt")
    var x = 0
    var y = 0

    for (command in commands) {
        val parts = command.split(" ")
        val direction = parts[0]
        val amount = parts[1].toInt()

        when (direction) {
            "forward" -> x += amount
            "down" -> y += amount
            "up" -> y -= amount
        }
    }

    val result = x * y

    println(result)
}