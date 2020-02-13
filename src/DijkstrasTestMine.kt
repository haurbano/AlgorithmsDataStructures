class DijkstrasTestMine {
    val graph = arrayOf(
        intArrayOf(0, 4,  0, 0,  0,  0, 0, 8,  0),
        intArrayOf(4, 0,  8, 0,  0,  0, 0, 11, 0),
        intArrayOf(0, 8,  0, 7,  0,  4, 0, 0,  2),
        intArrayOf(0, 0,  7, 0,  9, 14, 0, 0,  0),
        intArrayOf(0, 0,  0, 9,  0, 10, 0, 0,  0),
        intArrayOf(0, 0,  4, 14, 10, 0, 2, 0,  0),
        intArrayOf(0, 0,  0, 0,  0,  2, 0, 1,  6),
        intArrayOf(8, 11, 0, 0,  0,  0, 1, 0,  7),
        intArrayOf(0, 0,  2, 0,  0,  0, 6, 7,  0)
    )

    fun run() {
        val dijkstrasTest = DijkstrasTestH(graph)
        val result = dijkstrasTest.runDijkstras(3)
        printResult(result)
    }

    fun printResult(res: Array<Int>) {
        res.forEachIndexed { index, result ->
            println("$index -> $result")
        }
    }
}

class DijkstrasTestH(private val graph: Array<IntArray>) {

    fun runDijkstras(source: Int): Array<Int> {
        val outPutDistances = Array(graph.size) {Int.MAX_VALUE}
        val analyzedNodes = Array(graph.size) {false}

        //  source is always zero
        outPutDistances[source] = 0

        for (node in graph.indices) {
            val minDistanceIndexNode = mindDistance(outPutDistances, analyzedNodes)

            analyzedNodes[minDistanceIndexNode] = true

            for (index in outPutDistances.indices){
                if (!analyzedNodes[index] &&
                        graph[minDistanceIndexNode][index] != 0 &&
                        outPutDistances[index] > graph[minDistanceIndexNode][index] + outPutDistances[minDistanceIndexNode])
                {
                    outPutDistances[index] = graph[minDistanceIndexNode][index] + outPutDistances[minDistanceIndexNode]
                }
            }

        }
        return outPutDistances
    }

    private fun mindDistance(outPutDistances: Array<Int>, analyzedNodes: Array<Boolean>): Int {
        var minValue = Int.MAX_VALUE
        var minIndex = -1
        outPutDistances.forEachIndexed { index, value ->
            if (!analyzedNodes[index] &&  value < minValue) {
                minValue = value
                minIndex = index
            }
        }
        return minIndex
    }
}