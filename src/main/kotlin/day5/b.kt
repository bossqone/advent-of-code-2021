package day5

import loadInput

fun main() {
    val pointPairs = loadInput("05.txt").map { input ->
        val (from, to) = input.split(" -> ").map { value ->
            val (x, y) = value.split(",").map(String::toInt)
            Point(x, y)
        }
        PointPair(from, to)
    }

    val totalMaxY = pointPairs.flatMap { listOf(it.from.y, it.to.y) }.maxOf { it }
    val totalMaxX = pointPairs.flatMap { listOf(it.from.x, it.to.x) }.maxOf { it }

    val table: Table = MutableList(totalMaxY + 1) {
        val row: Row = MutableList(totalMaxX + 1) { 0 }
        row
    }

    for (pointPair in pointPairs) {
        var x = pointPair.from.x
        var y = pointPair.from.y

        while (true) {
            table[y][x]++

            if (x == pointPair.to.x && y == pointPair.to.y) {
                break
            }

            if (x < pointPair.to.x) {
                x++
            } else if (x > pointPair.to.x) {
                x--
            }

            if (y < pointPair.to.y) {
                y++
            } else if (y > pointPair.to.y) {
                y--
            }
        }
    }

    val result = table.sumOf { row -> row.count { it >= 2 } }
    println(result)
}