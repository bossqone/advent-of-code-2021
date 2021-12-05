package day4

typealias Table = MutableList<Row>
typealias Row = MutableList<Field>

data class Field(val value: Int, val marked: Boolean = false)