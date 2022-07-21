import kotlin.math.sqrt

// N is the size of the 2D matrix   N*N
private const val n = 9

/* Takes a partially filled-in grid and attempts
to assign values to all unassigned locations in
such a way to meet the requirements for
Sudoku solution (non-duplication across rows,
columns, and boxes) */
fun solveSudoku(
    grid: Array<IntArray>,
    r: Int,
    c: Int
): Boolean {

    /*if we have reached the 8th
       row and 9th column (0
       indexed matrix) ,
       we are returning true to avoid further
       backtracking       */
    var row = r
    var col = c
    if (row == n - 1 && col == n) return true

    // Check if column value  becomes 9 ,
    // we move to next row
    // and column start from 0
    if (col == n) {
        row++
        col = 0
    }

    // Check if the current position
    // of the grid already
    // contains value >0, we iterate
    // for next column
    if (grid[row][col] != 0) return solveSudoku(grid, row, col + 1)
    for (num in 1..n) {

        // Check if it is safe to place
        // the num (1-9)  in the
        // given row ,col ->we move to next column
        if (isSafe(grid, row, col, num)) {

            /*  assigning the num in the current
            (row,col)  position of the grid and
            assuming our assigned num in the position
            is correct */
            grid[row][col] = num

            // Checking for next
            // possibility with next column
            if (solveSudoku(grid, row, col + 1)) return true
        }
        /* removing the assigned num , since our
           assumption was wrong , and we go for next
           assumption with diff num value   */
        grid[row][col] = 0
    }
    return false
}

/* A utility function to print grid */
fun print(grid: Array<IntArray>) {
    for (i in 0 until n) {
        for (j in 0 until n) print(grid[i][j].toString() + " ")
        println()
    }
}

// Check whether it will be legal
// to assign num to the
// given row, col
private fun isSafe(
    grid: Array<IntArray>,
    row: Int,
    col: Int,
    num: Int
): Boolean {

    // Check if we find the same num
    // in the similar row , we
    // return false
    for (x in 0 until n) if (grid[row][x] == num) return false

    // Check if we find the same num
    // in the similar column ,
    // we return false
    for (x in 0 until n) if (grid[x][col] == num) return false

    // Check if we find the same num
    // in the particular 3*3
    // matrix, we return false
    val startRow = (row - row % sqrt(n)).toInt()  //3 -> 3
    val startCol = (col - col % sqrt(n)).toInt()  //2 -> 0
    for (i in 0 until sqrt(n).toInt())
        for (j in 0 until sqrt(n).toInt())
            if (grid[i + startRow][j + startCol] == num) return false
    return true
}

private fun sqrt(n: Int): Double = sqrt(n.toDouble())
