import java.util.ArrayList

fun main(args: Array<String>) {
    val test = SolutionPark()
    val grid = mutableListOf<List<Int>>().apply {
        add(listOf(1,1,1,0,0,1,1,0))
        add(listOf(1,0,1,0,1,1,0,1))
        add(listOf(0,0,0,1,1,0,1,1))
        add(listOf(0,1,1,1,0,1,1,0))
        add(listOf(0,1,1,0,1,1,0,0))
        add(listOf(1,0,0,1,1,0,0,0))
        add(listOf(0,0,0,1,0,0,0,1))
        add(listOf(1,0,0,1,1,1,1,1))
    }
    val r = test.numberAmazonTreasureTrucks(8, 8, grid)
    println(r)
}


