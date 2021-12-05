package day4

import loadInput

fun main() {
    val rows = loadInput("04.txt").toMutableList()
    val inputs = rows.removeFirst().split(",").map(String::toInt)
    val tables = mutableListOf<Table>()

    while (true) {
        val row = rows.removeFirstOrNull() ?: break
        if (row.isEmpty()) {
            tables.add(mutableListOf())
        } else {
            val tableRow = row.split(" ").filter(String::isNotEmpty).map(String::toInt).map(::Field).toMutableList()
            tables.last().add(tableRow)
        }
    }

    val result = calculate(inputs, tables)

    println(result)
}

private fun calculate(inputs: List<Int>, tables: List<Table>): Int? {
    for (input in inputs) {
        for (table in tables) {
            for (row in table) {
                for ((i, field) in row.withIndex()) {
                    if (field.value == input) {
                        row[i] = field.copy(marked = true)

                        val rowMarked = row.all(Field::marked)
                        val columnMarked = table.map { it[i] }.all(Field::marked)

                        if (rowMarked || columnMarked) {
                            val sum = table.sumOf { r -> r.filterNot(Field::marked).sumOf(Field::value) }
                            return sum * input
                        }
                    }
                }
            }
        }
    }
    return null
}