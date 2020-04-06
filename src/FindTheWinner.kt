class FindTheWinner {
    fun winner(andrea: Array<Int>, maria: Array<Int>, s: String): String {
        val validation = if (s == "Even") {
            { x: Int -> x % 2 == 0}
        } else {
            { x: Int -> x % 2 != 0}
        }
        return calculateWinner(andrea, maria, validation)
    }

    private fun calculateWinner(andrea: Array<Int>, maria: Array<Int>, validation: (Int) -> Boolean): String {
        val andreaDiff = Array(andrea.size){0}
        val mariaDiff = Array(andrea.size){0}
        for (i: Int in andrea.indices) {
            if (validation(i)){
                andreaDiff[i] = andrea[i] - maria[i]
                mariaDiff[i] = maria[i] - andrea[i]
            }
        }
        val mariaTotalScore = calculateTotalSum(mariaDiff)
        val andreaTotalScore = calculateTotalSum(andreaDiff)

        return when {
            mariaTotalScore > andreaTotalScore -> "Maria"
            andreaTotalScore > mariaTotalScore -> "Andrea"
            else -> "Tie"
        }
    }

    private fun calculateTotalSum(array: Array<Int>): Int {
        var totalScore = 0
        array.forEach { i -> totalScore += i }
        return totalScore
    }
}