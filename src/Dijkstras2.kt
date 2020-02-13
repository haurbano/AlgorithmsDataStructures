import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Dijkstras2 {
    fun run() {
        val scanner = Scanner(System.`in`)

        val numOfqueries = scanner.nextInt()
        val queries = arrayListOf<Query>()

        for (q in 0 until numOfqueries) {
            val nodesNum = scanner.nextInt()
            val edgesNum = scanner.nextInt()

            val nodes = HashMap<Int, ArrayList<Int>>()

            for (e in 0 until edgesNum) {
                val startPoint = scanner.nextInt()
                val endPoint = scanner.nextInt()

                val connection = nodes[startPoint] ?: arrayListOf()
                nodes[startPoint] = connection.apply { add(endPoint) }

                val connectionReverse = nodes[endPoint] ?: arrayListOf()
                nodes[endPoint] = connectionReverse.apply { add(startPoint) }
            }

            val startPoint = scanner.nextInt()

            queries.add(Query(nodesNum, nodes, startPoint))
        }

        queries.forEach { calculateDistances(it) }
    }

    fun calculateDistances(query: Query) {
        val distances = HashMap<Int, Int>()
        val visited = ArrayList<Int>()

        // Start point distance is 0
        distances[query.startPoint] = 0

        getDistanceFromNode(distances, visited, query.nodes)
        for (node in 1..query.nodesSize) {
            if (distances[node] == null) distances[node] = -1
        }
        printAnswer(distances.apply { remove(query.startPoint) })
    }

    fun getDistanceFromNode(distances: HashMap<Int, Int>, visited: ArrayList<Int>, nodes: HashMap<Int, ArrayList<Int>>) {
        for (i in 1..nodes.keys.size) {
            val node = getMinDistanceAndNotVisited(distances, visited)
            visited.add(node)
            nodes[node]?.forEach { connectionNode ->
                val conNodeCurrentDistance = distances[connectionNode] ?: Int.MAX_VALUE
                if (!visited.contains(connectionNode) &&
                    conNodeCurrentDistance > distances[node]!! + DEFAULT_DISTANCE) {
                    distances[connectionNode] = distances[node]!! + DEFAULT_DISTANCE
                }
            }
        }
    }

    fun getMinDistanceAndNotVisited(distances: HashMap<Int, Int>, visited: ArrayList<Int>): Int {
        var minValue = Int.MAX_VALUE
        var minNode = -1
        distances.forEach { node, distanceValue ->
            if (!visited.contains(node) &&
                distanceValue < minValue)
            {
                minValue = distanceValue
                minNode = node
            }
        }

        return minNode
    }

    fun printAnswer(distances: HashMap<Int, Int>) {
        distances.values.forEach {
            print(it)
            print(" ")
        }
        println("")
    }
}

data class Query(
    val nodesSize: Int,
    val nodes: HashMap<Int, ArrayList<Int>>,
    val startPoint: Int
)

const val DEFAULT_DISTANCE = 6