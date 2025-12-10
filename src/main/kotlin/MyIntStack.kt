fun main() {
    val stack = MyIntStack(10)

    stack.push(1)
    println(stack)

    stack.push(5)
    println(stack)

    stack.push(3)
    println(stack)

    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
}

class MyIntStack(
    size: Int,
) {
    private val data = IntArray(size)
    private var top = -1

    fun push(n: Int) {
        data[++top] = n
    }

    fun pop(): Int {
        return data[top--]
    }

    override fun toString(): String {
        return data.copyOfRange(0, top + 1).contentToString()
    }
}
