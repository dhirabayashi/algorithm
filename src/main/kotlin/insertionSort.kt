fun main() {
    val array = intArrayOf(4,2,7,3,7,3,1,5,2,1,10,0,2)
    println(array.toList())

    insertionSort(array)

    println(array.toList())
}

fun insertionSort(array: IntArray) {
    if(array.size < 2) {
        return
    }

    for(i in 1 until array.size) {
        for(j in i downTo 1) {
            if(array[j-1] > array[j]) {
                array.swap(j-1, j)
            }
        }
    }
}

private fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}
