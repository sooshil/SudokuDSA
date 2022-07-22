fun main() {
    /**
     *
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)

    node1.next = node2
    node2.next = node3

    //println(node1)


    val list = LinkedList<Int>()
    list.push(5).push(2).push(1).append(10)
    println(list)
    list.insertAfter(value = 200, afterNode = list.nodeAt(1) ?: Node(500))
    println(list)
     */

    //printSudokuGrid()

    printUnsolvedSudoku()

}

fun printSudokuGrid() {
    val grid = arrayOf(
        intArrayOf(3, 0, 6, 5, 0, 8, 4, 0, 0),
        intArrayOf(5, 2, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
        intArrayOf(0, 0, 3, 0, 1, 0, 0, 8, 0),
        intArrayOf(9, 0, 0, 8, 6, 3, 0, 0, 5),
        intArrayOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
        intArrayOf(1, 3, 0, 0, 0, 0, 2, 5, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 7, 4),
        intArrayOf(0, 0, 5, 2, 0, 6, 3, 0, 0)
    )
    val begin = System.nanoTime()
    val begin1 = System.currentTimeMillis()
    if (solveSudoku(grid, 0, 0)) print(grid) else println("No Solution exists")
    //if (solveSudoku(grid)) print(grid) else println("No Solution exists")
    val end = System.nanoTime()
    val end1 = System.currentTimeMillis()
    println("The total time taken is: ${end - begin} nanoseconds")
    println("The total time1 taken is: ${end1 - begin1} milliseconds")
}

fun printUnsolvedSudoku() {

    val begin = System.nanoTime()
    val begin1 = System.currentTimeMillis()

    val k = 40
    val sudoku = Sudoku(9, k)
    sudoku.fillValues()
    sudoku.printSudoku()
    val end = System.nanoTime()
    val end1 = System.currentTimeMillis()
    println("The total time taken is: ${end - begin} nanoseconds")
    println("The total time1 taken is: ${end1 - begin1} milliseconds")
}