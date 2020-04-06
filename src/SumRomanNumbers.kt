import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.HashMap

class SumRomanNumbers {
    private val romanNumbersMap = HashMap<String, Int>().apply {
        this["I"] = 1
        this["V"] = 5
        this["X"] = 10
        this["L"] = 50
        this["C"] = 100
        this["D"] = 500
        this["M"] = 1000
    }

    fun sum(num1: String, num2: String) {

    }

    fun romanToNum(num: String): Int {
        val chars = num.toCharArray()
        val totalSum = ArrayDeque<Int>()
        val tempNumber = Stack<Int>()
        var pointer = 0

        // M CD L IIIX
        while (pointer < chars.size) {
            val letter = chars[pointer]
            val currentNumber = romanNumbersMap[letter.toString()] ?: throw IllegalArgumentException("Invalid letter")
            when {
                totalSum.isEmpty() -> {
                    totalSum.add(currentNumber)
                }
                totalSum.peek() < currentNumber -> {
                    totalSum.add(currentNumber)
                    totalSum.add(calculateNum(tempNumber))
                    tempNumber.clear()
                }
                else -> {
                    tempNumber.add(currentNumber)
                }
            }
            pointer++
        }
        return totalSum.sum()
    }

    private fun calculateNum(stack: Stack<Int>): Int {
        if (stack.isEmpty()) return 0

        var num = stack.pop()
        while (stack.isNotEmpty()) {
            num -= stack.pop()
        }
        return num
    }

//    private fun numToRoman(num: Int): String {
//
//    }
}
