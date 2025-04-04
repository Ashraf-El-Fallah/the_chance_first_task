package sudoku

import IPv4.checkValidSudoku

/**
 * Task Instructions:

After completing the instructional videos, implement a Sudoku checker function that determines whether a given Sudoku puzzle is valid or not.
 * A valid Sudoku must not contain any repeated numbers in the same row, column, or 3x3 subgrid (box). Use the character '-' to represent empty cells within the puzzle.

- The function should return a Boolean value only—true if the Sudoku is valid, and false otherwise.

- You must follow a Test-Driven Development (TDD) approach while building this function:

- Create a check function, as demonstrated in the tutorial,
 *  and write all necessary tests first without implementing any logic inside the actual Sudoku checker function.
 * Initially, the function should always return false.
Present your written test cases to your mentor during the daily meeting.
Once your mentor approves the test cases,
 *  proceed to implement the logic in the function incrementally until all test cases pass successfully.
After completing the implementation, design a full flowchart representing the logic of the function using draw.io.

Extra: you can make the function dynamic and accept different size of the game like 4 * 4 or 16 * 16 not only 3 * 3
 */
fun main() {
    test(
        name = "when given a valid 9x9 board with all filled cells should return true",
        result = checkValidSudoku(
            listOf(
                listOf('5', '3', '_', '_', '7', '_', '_', '_', '_'),
                listOf('6', '_', '_', '1', '9', '5', '_', '_', '_'),
                listOf('_', '9', '8', '_', '_', '_', '_', '6', '_'),
                listOf('8', '_', '_', '_', '6', '_', '_', '_', '3'),
                listOf('4', '_', '_', '8', '_', '3', '_', '_', '1'),
                listOf('7', '_', '_', '_', '2', '_', '_', '_', '6'),
                listOf('_', '6', '_', '_', '_', '_', '2', '8', '_'),
                listOf('_', '_', '_', '4', '1', '9', '_', '_', '5'),
                listOf('_', '_', '_', '_', '8', '_', '_', '7', '9')
            ),
        ),
        correctResult = true,
    )

    test(
        name = "when given a board with repeated number in the same row should return false",
        result = checkValidSudoku(
            listOf(
                listOf('5', '3', '5', '_', '7', '_', '_', '_', '_'),
                listOf('6', '_', '_', '1', '9', '5', '_', '_', '_'),
                listOf('_', '9', '8', '_', '_', '_', '_', '6', '_'),
                listOf('8', '_', '_', '_', '6', '_', '_', '_', '3'),
                listOf('4', '_', '_', '8', '_', '3', '_', '_', '1'),
                listOf('7', '_', '_', '_', '2', '_', '_', '_', '6'),
                listOf('_', '6', '_', '_', '_', '_', '2', '8', '_'),
                listOf('_', '_', '_', '4', '1', '9', '_', '_', '5'),
                listOf('_', '_', '_', '_', '8', '_', '_', '7', '9')
            ),
        ),
        correctResult = false,
    )

    test(
        name = "when given a board with repeated number in the same column should return false",
        result = checkValidSudoku(
            listOf(
                listOf('5', '3', '_', '_', '7', '_', '_', '_', '_'),
                listOf('6', '_', '_', '1', '9', '5', '_', '_', '_'),
                listOf('_', '9', '8', '_', '_', '_', '_', '6', '_'),
                listOf('8', '_', '_', '_', '6', '_', '_', '_', '3'),
                listOf('4', '_', '_', '8', '_', '3', '_', '_', '1'),
                listOf('7', '_', '_', '_', '2', '_', '_', '_', '6'),
                listOf('_', '6', '_', '_', '_', '_', '2', '8', '_'),
                listOf('_', '_', '_', '4', '1', '9', '_', '_', '5'),
                listOf('5', '_', '_', '_', '8', '_', '_', '7', '9')
            ),
        ),
        correctResult = false,
    )

    test(
        name = "when given a board with repeated number in the same 3x3 box should return false",
        result = checkValidSudoku(
            listOf(
                listOf('5', '3', '_', '_', '7', '_', '_', '_', '_'),
                listOf('6', '_', '3', '1', '9', '5', '_', '_', '_'),
                listOf('_', '9', '8', '_', '_', '_', '_', '6', '_'),
                listOf('8', '_', '_', '_', '6', '_', '_', '_', '3'),
                listOf('4', '_', '_', '8', '_', '3', '_', '_', '1'),
                listOf('7', '_', '_', '_', '2', '_', '_', '_', '6'),
                listOf('_', '6', '_', '_', '_', '_', '2', '8', '_'),
                listOf('_', '_', '_', '4', '1', '9', '_', '_', '5'),
                listOf('_', '_', '_', '_', '8', '_', '_', '7', '9')
            ),
        ),
        correctResult = false,
    )

    test(
        name = "when given a board with an invalid character should return false",
        result = checkValidSudoku(
            listOf(
                listOf('5', '3', '_', '_', '7', '_', '_', '_', '_'),
                listOf('6', '_', '_', '1', '9', '5', '_', '_', '_'),
                listOf('_', '9', 'A', '_', '_', '_', '_', '6', '_'),
                listOf('8', '_', '_', '_', '6', '_', '_', '_', '3'),
                listOf('4', '_', '_', '8', '_', '3', '_', '_', '1'),
                listOf('7', '_', '_', '_', '2', '_', '_', '_', '6'),
                listOf('_', '6', '_', '_', '_', '_', '2', '8', '_'),
                listOf('_', '_', '_', '4', '1', '9', '_', '_', '5'),
                listOf('_', '_', '_', '_', '8', '_', '_', '7', '9')
            ),
        ),
        correctResult = false,
    )
    test(
        name = "when given a board with zero should return false",
        result = checkValidSudoku(
            listOf(
                listOf('5', '3', '_', '_', '7', '_', '_', '_', '_'),
                listOf('6', '_', '_', '1', '9', '5', '_', '_', '_'),
                listOf('_', '9', '0', '_', '_', '_', '_', '6', '_'),
                listOf('8', '_', '_', '_', '6', '_', '_', '_', '3'),
                listOf('4', '_', '_', '8', '_', '3', '_', '_', '1'),
                listOf('7', '_', '_', '_', '2', '_', '_', '_', '6'),
                listOf('_', '6', '_', '_', '_', '_', '2', '8', '_'),
                listOf('_', '_', '_', '4', '1', '9', '_', '_', '5'),
                listOf('_', '_', '_', '_', '8', '_', '_', '7', '9')
            ),
        ),
        correctResult = false,
    )
}

fun test(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed  - $name")
    }
}