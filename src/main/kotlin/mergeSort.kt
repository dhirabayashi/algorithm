fun main() {
    val array = intArrayOf(4,2,7,3,7,3,1,5,2,1,10,0,2)
    println(array.toList())

    val result = mergeSort(array)

    println(result.toList())
}

fun mergeSort(array: IntArray): IntArray {
    if(array.size < 2) {
        return array
    }

    val half = array.size / 2
    val leftHalf = mergeSort(array.takeAsIntArray(half))
    val rightHalf = mergeSort(array.takeLastAsIntArray(array.size - half))

    val result = IntArray(array.size)
    var i = 0
    var li = 0
    var ri = 0
    while (li != leftHalf.size && ri != rightHalf.size) {
        if(leftHalf[li] <= rightHalf[ri]) {
            result[i] = leftHalf[li]
            li++
        } else {
            result[i] = rightHalf[ri]
            ri++
        }

        i++
    }

    var j: Int
    val restArray: IntArray

    if(li == leftHalf.size) {
        j = ri
        restArray = rightHalf
    } else {
        j = li
        restArray = leftHalf
    }

    for(k in i until result.size) {
        result[k] = restArray[j]
        j++
    }

    return result
}

fun IntArray.takeAsIntArray(n: Int): IntArray {
    val array = IntArray(n)
    for(i in 0 until n) {
        array[i] = this[i]
    }
    return array
}

fun IntArray.takeLastAsIntArray(n: Int): IntArray {
    val array = IntArray(n)
    val start = (this.size - 1) - (n - 1)
    val diff = this.size - n
    for(i in start until this.size) {
        array[i - diff] = this[i]
    }
    return array
}
