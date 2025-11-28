fun main() {
    val costTable = arrayOf(
        intArrayOf(20, 13, 8, 10, 17),
        intArrayOf(10, 5, 7, 12, 8),
        intArrayOf(14, 20, 15, 13, 15),
        intArrayOf(18, 30, 20, 25, 22),
        intArrayOf(35, 8, 18, 20, 12),
    )

    val assignedJobs = mutableSetOf<Int>()

    var total = 0

    for(man in 0 until 5) {
        var min = Int.MAX_VALUE
        var assignedJob = -1

        for(job in 0 until 5) {
            val cost = costTable[job][man]

            if(cost < min && job !in assignedJobs) {
                min = cost
                assignedJob = job
            }
        }
        assignedJobs.add(assignedJob)
        total += min
    }

    println(total)
}
