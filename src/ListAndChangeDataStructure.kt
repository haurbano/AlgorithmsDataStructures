class ListAndChangeDataStructure {
    fun runTest() {
        val home = "Home"
        val storeA = "Store A"
        val storeB = "StoreB"
        val school = "School"
        val intersection = "Intersection"

        val paths =  arrayOf(
            Pair(home, storeA),
            Pair(storeA, home),
            Pair(home, storeB),
            Pair(home, intersection),
            Pair(storeA, storeB),
            Pair(storeB, school),
            Pair(school, storeB),
            Pair(intersection, school)
        )

        val map = hashMapOf<String, ArrayList<String>>()

        paths.forEach { path ->
            val  list = (map[path.first] ?: arrayListOf()).apply { add(path.second) }

            map[path.first] = list
        }

        map.keys.forEach {
            println("------")
            println("Key: $it")
            map[it]?.forEach { value -> println(value) }
        }
    }
}