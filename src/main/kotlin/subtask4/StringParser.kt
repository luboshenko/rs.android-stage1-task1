package subtask4
import java.util.Stack

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val stack1 = Stack<Int>()
        val stack2 = Stack<Int>()
        val stack3 = Stack<Int>()

        val preliminaryResult = mutableListOf<IndexedString>()

        val extractResult: (Stack<Int>, Int) -> Unit = { stack, i ->
            if(stack.isNotEmpty()) {
                val startIndex = stack.pop()+1
                preliminaryResult.add(IndexedString(startIndex, inputString.substring(startIndex, i)))
            }
        }

        inputString.forEachIndexed { index, c ->
            when(c) {
                '(' -> stack1.push(index)
                '[' -> stack2.push(index)
                '<' -> stack3.push(index)
                ')' -> extractResult(stack1, index)
                ']' -> extractResult(stack2, index)
                '>' -> extractResult(stack3, index)
            }
        }
        preliminaryResult.sortBy { it.startIndex }
        return Array(preliminaryResult.size) { i -> preliminaryResult[i].str}
    }

    class IndexedString(val startIndex: Int, val str: String)
}
