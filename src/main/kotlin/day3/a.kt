package day3

import loadInput

fun main() {
    val numbers = loadInput("03.txt")
    val size = numbers[0].length

    val gammaList = mutableListOf<Char>()
    val epsilonList = mutableListOf<Char>()

    for (index in 0 until size) {
        var count1 = 0
        var count0 = 0

        for (number in numbers) {
            when (number[index]) {
                '1' -> count1++
                '0' -> count0++
            }
        }

        if (count1 > count0) {
            gammaList.add(index, '1')
            epsilonList.add(index, '0')
        } else {
            gammaList.add(index, '0')
            epsilonList.add(index, '1')
        }
    }

    val gamma = gammaList.joinToString("").toInt(2)
    val epsilon = epsilonList.joinToString("").toInt(2)

    val result = gamma * epsilon

    println(result)
}