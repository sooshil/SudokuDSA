import kotlin.math.floor
import kotlin.math.sqrt

class Sudoku(
    val gridSize: Int,
    difficulty: Difficulty
) {
    var grid: Array<IntArray> = Array(gridSize) { IntArray(gridSize) }
    private var subgridSize = sqrt(gridSize.toDouble()).toInt()

    private val removeNumberCount = if (gridSize == 4) {
        when (difficulty) {
            Difficulty.EASY -> 2
            Difficulty.MEDIUM -> 4
            else -> 5
        }
    } else {
        when (difficulty) {
            Difficulty.EASY -> randomBetween(20, 25)
            Difficulty.MEDIUM -> randomBetween(35, 45)
            else -> randomBetween(55, 65)
        }
    }

    init {
        fillValues()
    }

    fun fillValues() {
        fillDiagonal()
        fillRemaining(0, subgridSize)
        removeKDigits()
    }

    /** first fills the n*n subgrid diagonally. */
    private fun fillDiagonal() {
        var n = 0
        while (n < gridSize) {
            var num: Int
            for (i in 0 until subgridSize) {
                for (j in 0 until subgridSize) {
                    do {
                        num = random(gridSize)
                    } while (safeInSubGrid(n, n, num).not())
                    grid[n + i][n + j] = num
                }
            }
            n += subgridSize
        }
    }

    private fun isSafe(row: Int, column: Int, num: Int): Boolean {
        return safeInRow(row, num) &&
                safeInColumn(column, num) &&
                safeInSubGrid(row - row % subgridSize, column - column % subgridSize, num)
    }

    private fun safeInRow(row: Int, num: Int): Boolean {
        for (i in 0 until gridSize) if (grid[row][i] == num) return false
        return true
    }

    private fun safeInColumn(column: Int, num: Int): Boolean {
        for (i in 0 until gridSize) if (grid[i][column] == num) return false
        return true
    }

    private fun safeInSubGrid(rowStart: Int, colStart: Int, num: Int): Boolean {
        for (i in 0 until subgridSize)
            for (j in 0 until subgridSize)
                if (grid[rowStart + i][colStart + j] == num) return false
        return true
    }

    private fun random(num: Int): Int {
        return floor(Math.random() * num + 1).toInt()
    }

    private fun randomBetween(num1: Int, num2: Int): Int {
        return when {
            num1 == num2 -> num1
            num1 < num2 -> (num1..num2).random()
            else -> (num2..num1).random()
        }
    }

    // A recursive function to fill remaining
    // matrix
    private fun fillRemaining(r: Int, c: Int): Boolean {
        var row = r
        var column = c
        if (column >= gridSize && row < gridSize - 1) {
            row += 1
            column = 0
        }
        if (row >= gridSize && column >= gridSize) return true
        if (row < subgridSize) {
            if (column < subgridSize) column = subgridSize
        } else if (row < gridSize - subgridSize) {
            if (column == (row / subgridSize) * subgridSize) column += subgridSize
        } else {
            if (column == gridSize - subgridSize) {
                row += 1
                column = 0
                if (row >= gridSize) return true
            }
        }
        for (num in 1..gridSize) {
            if (this.isSafe(row, column, num)) {
                grid[row][column] = num
                if (fillRemaining(row, column + 1)) return true
                grid[row][column] = 0
            }
        }
        return false
    }

    // Remove the K no. of digits to
    // complete game
    private fun removeKDigits() {
        var count = removeNumberCount
        while (count != 0) {
            val cellId = random(gridSize * gridSize) - 1

            val i = cellId / gridSize //15/9=1
            val j = cellId % gridSize //15%9=6

            if (grid[i][j] != 0) {
                count--
                grid[i][j] = 0
            }
        }
    }


}

// Print sudoku
fun Sudoku.printSudoku() {
    for (i in 0 until gridSize) {
        for (j in 0 until gridSize) print(grid[i][j].toString() + " ")
        println()
    }
    println()
}

enum class Difficulty(level: Int) {
    EASY(0),
    MEDIUM(1),
    HARD(2)
}