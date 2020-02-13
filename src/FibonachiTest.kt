import java.time.LocalDateTime

class FibonachiTest {
    fun runTest() {
        val memory = arrayOfNulls<Int>(51)
        val startTime = LocalDateTime.now()

        println(startTime)
        val result = fibonacciMem(50, memory)
        // val result = calculateFibonacci(50)
        val endTime = LocalDateTime.now()
        println(endTime)

        println("Bibonachi: $result")
    }

    // recursion solution
    // It takes about 1 min
    private fun calculateFibonacci(target: Int): Int {
        return when {
            target == 1 -> 1
            target <= 0 -> 0
            else -> calculateFibonacci(target - 1) + calculateFibonacci(target - 2)
        }
    }

    //Memoized
    // It takes about 1 second √√
    private fun fibonacciMem(n: Int, memory: Array<Int?>): Int {
        memory[n]?.let { return it }

        val result = when {
            n == 1 -> 1
            n <= 0 -> 0
            else -> fibonacciMem(n - 1, memory) + fibonacciMem(n - 2, memory)
        }
        memory[n] = result
        return result
    }
}