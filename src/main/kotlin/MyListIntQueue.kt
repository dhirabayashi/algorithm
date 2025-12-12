fun main() {
    val queue = MyListIntQueue()
    queue.enqueue(1)
    queue.enqueue(3)
    queue.enqueue(5)

    println(queue.dequeue())
    queue.enqueue(7)

    println(queue.dequeue())
    println(queue.dequeue())
    queue.enqueue(9)

    println(queue.dequeue())
    println(queue.dequeue())

    repeat(1000) {
        queue.enqueue(it)
    }

    repeat(1000) {
        queue.dequeue()
    }
}

class MyListIntQueue {
    private var first: Node? = null
    private var last: Node? = null

    fun enqueue(n: Int) {
        val nextNode = Node(n, null)
        if(last == null) {
            last = nextNode
            first = nextNode
        } else {
            last!!.next = nextNode
            last = nextNode
        }
    }

    fun dequeue(): Int {
        if(first == null) {
            throw NoSuchElementException()
        }

        val value = first!!.value
        val next = first!!.next

        first = next
        if(next == null) {
            last = null
        }

        return value
    }
}

private data class Node(
    val value: Int,
    var next: Node?,
)
