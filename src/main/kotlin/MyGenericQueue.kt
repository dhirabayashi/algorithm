fun main() {
    val queue = MyGenericQueue<String>(5)
    queue.enqueue("test1")
    println(queue.dequeue())

    queue.enqueue("test2")
    queue.enqueue("test3")
    println(queue.dequeue())
    println(queue.dequeue())

    queue.enqueue("test4")
    queue.enqueue("test5")

    println(queue.dequeue())
    println(queue.dequeue())

    queue.enqueue("test6")
    println(queue.dequeue())

    queue.enqueue("test7")
    println(queue.dequeue())

    repeat(1000) {
        queue.enqueue(it.toString())
        queue.dequeue()
    }
}

class MyGenericQueue<E>(
    size: Int,
) {
    private val data =  Array<Any?>(size) { null } as Array<E>
    private var first = 0
    private var last = 0
    private var count = 0

    fun enqueue(elem: E) {
        if(count == data.size) {
            throw NoSuchElementException()
        }

        data[last] = elem
        last = nextIndex(last)
        count++
    }

    fun dequeue(): E {
        if(count == 0) {
            throw IllegalStateException()
        }
        val elem = data[first]
        first = nextIndex(first)
        count--

        return elem
    }

    private fun nextIndex(i: Int): Int {
        return (i + 1) % data.size
    }
}
