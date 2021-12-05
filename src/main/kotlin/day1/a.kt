package day1

import loadInput

fun main() {
    val values = loadInput("01.txt").map(Integer::parseInt)
    var lastValue: Int = Int.MAX_VALUE
    var increments = 0

    for (value in values) {
        if (value > lastValue) {
            increments++
        }
        lastValue = value
    }

    println(increments)
}