fun main() {
    val stack = MyGenericStack<String>(5)
    stack.push("test")
    stack.push("test2")
    println(stack.pop())

    stack.push("test3")

    println(stack.pop())
    println(stack.pop())
}

class MyGenericStack<E>(
    size: Int,
) {
    private val data = Array<Any?>(size) { null } as Array<E>
    private var top = -1

    fun push(elem: E) {
        if(top == data.size - 1) {
            throw IllegalStateException()
        }

        data[++top] = elem
    }

    fun pop(): E? {
        if(top < 0) {
            throw NoSuchElementException()
        }

        return data[top--]
     }
}
