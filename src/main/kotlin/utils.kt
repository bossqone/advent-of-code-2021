fun loadInput(path: String): List<String> {
    return {}::class.java.getResource(path).readText().lines()
}