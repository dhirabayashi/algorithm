fun main() {
    println(fib(10))
    println(fib(1))
    println(fib(2))
    println(fib(50))
}

fun fib(n: Int): Long {
    if(n == 0) {
        return 0L
    }

    if(n < 3) {
        return 1L
    }

    return fib(n - 2) + fib(n - 1)
}
