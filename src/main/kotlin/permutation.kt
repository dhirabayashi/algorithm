fun main() {
    perm(0)
}

val array = intArrayOf(1, 2, 3, 4)

fun perm(i: Int) {
    if(i == array.size) {
        println(array.joinToString(" "))
        return
    }

    for(j in i until array.size) {
        swap(array, i, j)
        perm(i + 1)
        swap(array, i, j)
    }
}

fun swap(array: IntArray, i: Int, j: Int) {
    val tmp = array[i]
    array[i] = array[j]
    array[j] = tmp
}
