fun main() {
    val array = MyIntArray((0..10).toList().toIntArray())

    println(array.max())
    println(array.total())
    println(array.average())
    println(array.variance())
}

data class MyIntArray(
    private val data: IntArray,
) {
    init {
        require(data.isNotEmpty())
    }

    fun max(): Int {
        var max = data.first()
        for(i in 1 until data.size) {
            if(data[i] > max) {
                max = data[i]
            }
        }

        return max
    }

    fun total(): Int {
        var sum = 0
        for(i in data.indices) {
            sum += data[i]
        }

        return sum
    }

    fun average(): Double {
        return total().toDouble() / data.size
    }

    fun variance(): Double {
        val average = average()

        var sum = 0.0
        for(i in data.indices) {
            val diff = data[i] - average
            sum += diff * diff
        }

        return sum / data.size
    }
}
