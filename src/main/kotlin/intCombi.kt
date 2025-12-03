fun main() {
    intCombi((1..15).toList().toIntArray(), 3, 0, emptyList())
}

fun intCombi(originalArray: IntArray, r: Int, start: Int, list: List<Int>) {
    if(list.size == r) {
        println(list)

        return
    }

    for(i in start until originalArray.size) {
        val n = originalArray[i]

        intCombi(originalArray, r, i + 1, list + listOf(n))
    }
}
