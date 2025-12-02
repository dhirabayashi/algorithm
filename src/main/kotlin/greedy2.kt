fun main() {
    println(countCoins(1))
    println(countCoins(298))
    println(countCoins(300))
}

fun countCoins(inputYen: Int): Int {
    val coins = intArrayOf(500, 100, 50, 10, 5, 1)

    var count = 0
    var yen = inputYen

    for(coin in coins) {
        val div = yen / coin
        val mod = yen % coin

        count += div
        yen = mod
    }

    return count
}
