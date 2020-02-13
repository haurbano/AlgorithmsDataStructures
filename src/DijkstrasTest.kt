class DijkstrasTest {
    fun run() {
        val graph = arrayOf(
            intArrayOf(0, 4, 0, 0, 0, 0, 0, 8, 0),
            intArrayOf(4, 0, 8, 0, 0, 0, 0, 11, 0),
            intArrayOf(0, 8, 0, 7, 0, 4, 0, 0, 2),
            intArrayOf(0, 0, 7, 0, 9, 14, 0, 0, 0),
            intArrayOf(0, 0, 0, 9, 0, 10, 0, 0, 0),
            intArrayOf(0, 0, 4, 14, 10, 0, 2, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 2, 0, 1, 6),
            intArrayOf(8, 11, 0, 0, 0, 0, 1, 0, 7),
            intArrayOf(0, 0, 2, 0, 0, 0, 6, 7, 0)
        )
        val t = ShortestPath()
        t.dijkstra(graph, 3)
    }
}

internal class ShortestPath {

    fun minDistance(dist: IntArray, sptSet: Array<Boolean?>): Int {
        var min = Int.MAX_VALUE
        var min_index = -1
        for (index in dist.indices){
            if (sptSet[index] == false && dist[index] <= min) {
                min = dist[index]
                min_index = index
            }
        }
        return min_index
    }

    // A utility function to print the constructed distance array
    fun printSolution(dist: IntArray) {
        println("Vertex \t\t Distance from Source")
        for (i in 0 until 9) println(i.toString() + " \t\t " + dist[i])
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    fun dijkstra(graph: Array<IntArray>, src: Int) {
        val size = graph.size
        val dist = IntArray(size) // The output array. dist[i] will hold the shortest distance from src to i
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        val sptSet = arrayOfNulls<Boolean>(size)
        // Initialize all distances as INFINITE and stpSet[] as false
        for (i in 0 until size) {
            dist[i] = Int.MAX_VALUE
            sptSet[i] = false
        }
        // Distance of source vertex from itself is always 0
        dist[src] = 0
        // Find shortest path for all vertices
        for (count in 0 until size - 1) { // Pick the minimum distance vertex from the set of vertices not yet processed. u is always equal to src in first iteration.
            val u = minDistance(dist, sptSet)
            // Mark the picked vertex as processed
            sptSet[u] = true
            // Update dist value of the adjacent vertices of the picked vertex.
            for (v in 0 until size)  // Update dist[v] only if is not in sptSet, there is an edge from u to v, and total weight of path from src to v through u is smaller than current value of dist[v]
                if (!sptSet[v]!! &&
                    graph[u][v] != 0 &&
                    dist[u] != Int.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v])
                {
                    dist[v] = dist[u] + graph[u][v]
                }
        }
        // print the constructed distance array
        printSolution(dist)
    }
}