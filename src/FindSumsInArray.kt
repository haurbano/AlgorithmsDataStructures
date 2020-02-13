class FindSumsInArray {
    // find number of possible combinations that sum 16
    val input = arrayOf(2,4,6,10)
    val expectedValue = 16
    var combinations = 0

    fun run() {
        sumNextNum(0,0, input)
        println(combinations)
    }

    private fun sumNextNum(nexIndex: Int,  prevValue: Int, array: Array<Int>) {
        for (i in nexIndex..array.size -1) {
            val newValue = prevValue + array[i]
            if (newValue == expectedValue) {
                combinations += 1
            }
        }
        if (nexIndex +1 < array.size) {
            sumNextNum(nexIndex + 1, prevValue + array[nexIndex], array)
        }
    }
}