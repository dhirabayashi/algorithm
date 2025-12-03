fun main() {
    for(a in 1 .. 9) {
        for(b in 0..9) {
            val sum = a + b
            if(sum * sum == a * 10 + b) {
                println("a = $a, b = $b")
            }
        }
    }

    val candidates = intArrayOf(4 * 4, 5 * 5, 6 * 6, 7 * 7, 8 * 8, 9 * 9)
    for(candidate in candidates) {
        val a = candidate / 10
        val b = candidate % 10
        val sum = a + b

        if(sum * sum == candidate) {
            println("a = $a, b = $b")
        }
    }
}
