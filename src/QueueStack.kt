import java.util.*

class QueueStack<T> {
    private val mainStack = Stack<T>()
    private val tempStack = Stack<T>()

    fun add(newElement: T) { // 3

        while (!mainStack.isEmpty()) {
            val ele = mainStack.pop()
            tempStack.add(ele) //[1, 2]
        }

        tempStack.add(newElement) //[1, 2, 3]

        while (!tempStack.isEmpty()) {
            val ele = tempStack.pop()
            mainStack.add(ele) //[3,2,1]
        }
    }

    fun remove(): T {
        return mainStack.pop()
    }
}