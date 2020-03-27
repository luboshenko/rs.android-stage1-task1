package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        return if(sadArray.size < 3) {
            sadArray
        } else {
            val happy = mutableListOf<Int>()
            sadArray.forEachIndexed { index, it ->
                if (index == 0 || index == sadArray.size - 1) {
                    happy.add(it)
                } else {
                    if(it <= sadArray[index - 1] + sadArray[index + 1]) {
                        happy.add(it)
                    }
                }
            }
            if(!happy.hasBadItems()) {
                return happy.toIntArray()
            }
            return convertToHappy(happy.toIntArray())
        }
    }

    private fun MutableList<Int>.hasBadItems(): Boolean {
        if(this.size < 3) {
            return false
        } else {
            for (i in 1..this.size-2) {
                if(this[i] > this[i-1] + this[i+1]) {
                    return true
                }
            }
            return false
        }
    }
}
