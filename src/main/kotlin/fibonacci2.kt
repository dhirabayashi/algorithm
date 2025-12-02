fun main() {
    println(fib2(10))
    println(fib2(1))
    println(fib2(2))
    println(fib2(50))
}

fun fib2(n: Int): Long {
    if(n == 0) {
        return 0
    }
    if(n < 3) {
        return 1
    }

    val dp = LongArray(n + 1)
    dp[1] = 1
    dp[2] = 1

    for(i in 3 .. n) {
        dp[i] = dp[i - 2] + dp[i - 1]
    }
    return dp[n]
}
