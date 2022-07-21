//import kotlin.math.sqrt
//
//fun isSafe(
//    grid: Array<IntArray>,
//    row: Int,
//    col: Int,
//    num: Int
//): Boolean {
//    /** row is safe */
//    for (c in grid.indices) if(grid[row][c] == num) return false
//
//    /** column is safe */
//    for (r in grid.indices) if(grid[r][col] == num) return false
//
//    /** subgrid is safe */
//    val subgridSize = sqrt(grid.size.toDouble()).toInt()
//    val subgridStartRow = row - row % subgridSize
//    val subgridStartColumn = col - col % subgridSize
//
//    for (i in subgridStartRow until subgridStartRow + subgridSize) {
//        for (j in subgridStartColumn until subgridStartColumn + subgridSize) {
//            if (grid[i][j] == num) return false
//        }
//    }
//
//    return true
//}
//
//fun solveSudoku(grid: Array<IntArray>): Boolean {
//    var row = -1
//    var col = -1
//    var isEmpty = true
//    for (i in grid.indices) {
//        for (j in grid.indices) {
//            if (grid[i][j] == 0) {
//                row = i
//                col = j
//                isEmpty = false
//                break
//            }
//        }
//        if (!isEmpty) {
//            break
//        }
//    }
//
//    // No empty space left
//    if (isEmpty) {
//        return true
//    }
//
//    // Else for each-row backtrack
//    for (num in 1..grid.size) {
//        if (isSafe(grid, row, col, num)) {
//            grid[row][col] = num
//            if (solveSudoku(grid)) {
//                // print(grid);
//                return true
//            } else {
//                // replace it
//                grid[row][col] = 0
//            }
//        }
//    }
//    return false
//}
//
//fun print(grid: Array<IntArray>) {
//    // We got the answer, just print it
//    for (r in grid.indices) {
//        for (c in grid.indices) {
//            print(grid[r][c])
//            print(" ")
//        }
//        println()
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
///**
//
//private const val n = 9
//
//private fun isSafe(
//    grid: Array<IntArray>,
//    row: Int,
//    column: Int,
//    num: Int
//): Boolean {
//
//    /** row */
//    for(i in 0 until n) if (grid[row][i] == num) return false
//
//    /** column */
//    for(i in 0 until n) if (grid[i][column] == num) return false
//
//    /** grid */
//    val subgridSize = sqrt(n.toDouble()).toInt() //3
//    val subgridStartRow = row - row % subgridSize  //4 - 1 = 3
//    val subgridStartColumn = column - column % subgridSize // 3 - 0 = 3
//
//    for (i in subgridStartRow until subgridStartRow + subgridSize) {
//        for (j in subgridStartColumn until subgridStartColumn + subgridSize) {
//            if (grid[i][j] == num) return false
//        }
//    }
//    return true
//}
//
//fun solveSudoku(
//    grid: Array<IntArray>,
//    number: Int
//): Boolean {
//    var row = -1
//    var col = -1
//    var isEmpty = true
//    for (i in 0 until number) {
//        for (j in 0 until number) {
//            if (grid[i][j] == 0) {
//                row = i
//                col = j
//
//                // We still have some remaining
//                // missing values in Sudoku
//                isEmpty = false
//                break
//            }
//        }
//        if (!isEmpty) {
//            break
//        }
//    }
//
//    // No empty space left
//    if (isEmpty) {
//        return true
//    }
//
//    // Else for each-row backtrack
//    for (num in 1..number) {
//        if (isSafe(grid, row, col, num)) {
//            grid[row][col] = num
//            if (solveSudoku(grid, number)) {
//                print(grid, number);
//                return true
//            } else {
//                // replace it
//                grid[row][col] = 0
//            }
//        }
//    }
//    return false
//}
//
//fun print(
//    grid: Array<IntArray>,
//    number: Int
//) {
//
//    // We got the answer, just print it
//    for (r in 0 until number) {
//        for (d in 0 until number) {
//            print(grid[r][d])
//            print(" ")
//        }
//        print("\n")
//        if ((r + 1) % sqrt(number.toDouble()).toInt() == 0) {
//            print("")
//        }
//    }
//}
//
// */