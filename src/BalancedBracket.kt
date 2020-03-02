import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class BalancedBracket {
    private val openBrackets = ArrayList<Char>().apply {
        add('[')
        add('{')
        add('(')
    }

    private val closeBracketMap = HashMap<Char, Char>().apply {
        this[']'] = '['
        this['}'] = '{'
        this[')'] = '('
    }

    fun run(s: String) {
        println(isBalanced(s))
    }

    private fun isBalanced(s: String): Boolean {
        val stack = Stack<Char>()
        val charArray = s.toCharArray()

        for (letter in charArray) {
            if (openBrackets.contains(letter)) {
                stack.add(letter)
            } else if(stack.isEmpty() || stack.pop() != closeBracketMap[letter]) {
                return false
            }
        }

        return s.isNotEmpty() && stack.isEmpty()
    }
}