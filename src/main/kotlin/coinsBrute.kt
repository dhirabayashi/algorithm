import kotlin.math.min

fun main() {
    coinBrute(1000, intArrayOf(11, 5, 1), 0, emptyList(), 0)
    println(sum)
}

var sum = Int.MAX_VALUE

fun coinBrute(yen: Int, coins: IntArray, i: Int, list: List<Int>, currentSum: Int) {
    if(coins.size == list.size) {
        if(currentSum == yen) {
            // println(list)

            sum = min(sum, list.sum())
        }

        return
    }

    val maxCount = (yen - currentSum) / coins[i]

    for(j in 0..maxCount) {
        coinBrute(yen, coins, i + 1, list + listOf(j), currentSum + coins[i] * j)
    }
}
