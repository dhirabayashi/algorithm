fun main() {
    val array = intArrayOf(4,2,7,3,7,3,1,5,2,1,10,0,2)
    println(array.toList())

    insertionSort(array)

    println(array.toList())

    if(!testSorted(1000, 1000)) {
        println("failed")
    }
}

fun insertionSort(array: IntArray) {
    if(array.size < 2) {
        return
    }

    for(i in 1 until array.size) {
        for(j in i downTo 1) {
            if(array[j-1] > array[j]) {
                array.swap(j-1, j)
            } else {
                break
            }
        }
    }
}

private fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

private fun testSorted(count: Int, limit: Int): Boolean {
    val valueRange = Int.MIN_VALUE..Int.MAX_VALUE
    val sizeRange = 0 until limit

    for(i in 0 until count) {
        val size = sizeRange.random()
        val array = IntArray(size)
        for(j in 0 until size) {
            array[j] = valueRange.random()
        }

        val copy = array.clone()
        insertionSort(array)

        if(array.toList() != copy.toList().sorted()) {
            println("failed")
            println("original: $copy")
            println("sorted: $array")
            return false
        }
    }
    return true
}
