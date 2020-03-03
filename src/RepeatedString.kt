class RepeatedString {
    fun run(s: String, n: Int): Int {
        val aInString = aInString(s)

        val multiplier = n / s.length

        val partialResult = multiplier * aInString

        val missingLettersCount = n % s.length

        val missingAs = aInString(s.substring(0, missingLettersCount))

        return partialResult + missingAs
    }

    private fun aInString(s: String): Int {
        var count = 0
        for (letter in s.toCharArray()) {
            if (letter == 'a') count += 1
        }
        return count
    }
}