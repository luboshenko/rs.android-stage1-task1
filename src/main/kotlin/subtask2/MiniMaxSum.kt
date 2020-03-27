package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        input.sort()
        return intArrayOf(input.slice(0 until input.size-1).sum(), input.slice(1 until input.size).sum())
    }
}
