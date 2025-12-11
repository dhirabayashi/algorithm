fun main() {
    val queue = MyIntQueue(5)
    queue.enqueue(3)
    queue.enqueue(5)
    queue.enqueue(7)

    println(queue.dequeue())
    println(queue.dequeue())

    queue.enqueue(2)

    println(queue.dequeue())
    queue.enqueue(100)
    println(queue.dequeue())
    println(queue.dequeue())

    repeat(100) {
        queue.enqueue(1)
        queue.dequeue()
    }
}

class MyIntQueue(
    size: Int,
) {
    private val data = IntArray(size)
    private var top = 0
    private var end = 0
    private var count = 0

    fun enqueue(n: Int) {
        if(count == data.size) {
            throw IllegalStateException()
        }

        data[end] = n
        end = nextIndex(end)
        count++
    }

    fun dequeue(): Int {
        if(count == 0) {
            throw NoSuchElementException()
        }

        val elem = data[top]
        top = nextIndex(top)
        count--

        return elem
    }

    private fun nextIndex(i: Int): Int {
        return (i + 1) % data.size
    }
}
