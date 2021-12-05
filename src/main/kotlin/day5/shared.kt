package day5

data class Point(val x: Int, val y: Int)
data class PointPair(val from: Point, val to: Point)

typealias Table = MutableList<Row>
typealias Row = MutableList<Value>
typealias Value = Int