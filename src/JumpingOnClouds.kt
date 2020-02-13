
// Find most shorter path from A to B avoiding some clouds
class JumpingOnClouds {
    // 0 can be jumped
    // 1 Must be avoid
    private val clouds = arrayOf(0, 0, 0, 0, 1, 0)
    private val steps = arrayListOf<Int>()

    fun run() {
        jump(index= 0, jumps= 0, clouds = clouds)
        println(steps.min() ?: 0)
    }

    private fun jump(index: Int, jumps: Int, clouds: Array<Int>) {
        if (index >= (clouds.size - 1)) {
            steps.add(jumps)
        } else {
            jump(index +1, jumps + 1, clouds)
            jump(index +2, jumps + 1, clouds)
        }
    }
}