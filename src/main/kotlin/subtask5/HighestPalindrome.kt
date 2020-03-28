package subtask5

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var differencesCounter = 0
        val result = StringBuilder(digitString)
        val foundDifferences = mutableListOf<Int>()

        for (i in 0 until n/2) {
            var c1 = digitString[i]
            val c2 = digitString[n-i-1]
            if(c1 != c2) {
                differencesCounter++
                if(c1 < c2) {
                    c1 = c2
                }
                result.setCharAt(i, c1)
                result.setCharAt(n-i-1, c1)
                if(c1 < '9') {
                    foundDifferences.add(i)
                }
            }
        }
        return when {
            differencesCounter > k -> {
                (-1).toString()
            }
            differencesCounter == k -> {
                result.toString()
            }
            else -> {
                tryToEnlarge(result, k - differencesCounter, foundDifferences).toString()
            }
        }
    }

    private fun tryToEnlarge(builder: StringBuilder, k: Int, differences: List<Int>): StringBuilder {
        val n = builder.length
        var changesLeft = k
        var i = 0
        while (changesLeft > 0 && i < n/2) {
            if(builder[i] < '9') {
                builder.setCharAt(i, '9')
                builder.setCharAt(n-i-1, '9')
                if(differences.contains(i)) {
                    changesLeft--
                } else {
                    changesLeft -= 2
                }
            }
            i++
        }
        return builder
    }
}
