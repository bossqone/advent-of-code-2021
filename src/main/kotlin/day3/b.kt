package day3

import loadInput

fun main() {
    val numbers = loadInput("03.txt")
    val size = numbers[0].length

    var oxygenNumbers = numbers
    var co2Numbers = numbers

    for (index in 0 until size) {
        if (oxygenNumbers.size > 1) {
            oxygenNumbers = filterNumbers(oxygenNumbers, index, true)
        }

        if (co2Numbers.size > 1) {
            co2Numbers = filterNumbers(co2Numbers, index, false)
        }
    }

    val oxygen = oxygenNumbers[0].toInt(2)
    val co2 = co2Numbers[0].toInt(2)

    val result = oxygen * co2

    println(result)
}

fun filterNumbers(numbers: List<String>, index: Int, mostCommon: Boolean): List<String> {
    var count1 = 0
    var count0 = 0

    for (number in numbers) {
        when (number[index]) {
            '1' -> count1++
            '0' -> count0++
        }
    }

    val char: Char
    if (mostCommon) {
        char = if (count1 > count0) {
            '1'
        } else if (count1 == count0) {
            '1'
        } else {
            '0'
        }
    } else {
        char = if (count1 > count0) {
            '0'
        } else if (count1 == count0) {
            '0'
        } else {
            '1'
        }
    }

    return numbers.filter { it[index] == char }
}