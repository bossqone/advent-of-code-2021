package day1

import loadInput

fun main() {
    val values = loadInput("01.txt").map(Integer::parseInt)
    var lastSum: Int = Int.MAX_VALUE
    var increments = 0

    for (i in 0..(values.size - 3)) {
        val sum = values[i] + values[i + 1] + values[i + 2]
        if (sum > lastSum) {
            increments++
        }
        lastSum = sum
    }

    println(increments)
}