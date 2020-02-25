import java.lang.IndexOutOfBoundsException

class QueueArray<T>(private val capacity: Int) {
    private val container = Array<Any?>(capacity){}
    private var head = 0;
    private var tail = 0;

    // [a,b,c,d,e]
    fun add(item: T) {
        if (head + 1 < capacity) {
            head++
            container[head] = (item as Any)
        } else {
            throw IndexOutOfBoundsException("Out of queue capacity")
        }
    }

    fun remove(): T? {
        if (container.isEmpty()) return null

        val item = container[head]

        container[head] = null
    }
}