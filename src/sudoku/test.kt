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
        name = "when given a valid board with all filled cells should return true",
        result = checkValidSudoku(
            listOf(
                listOf('1', '2', '3'),
                listOf('3', '1', '2'),
                listOf('2', '3', '1')
            ),
            size = 3,
        ),
        correctResult = true,
    )

    test(
        name = "when given a valid board with empty valid cells should return true",
        result = checkValidSudoku(
            listOf(
                listOf('1', '_', '3'),
                listOf('3', '1', '2'),
                listOf('_', '3', '1')
            ),
            size = 3,
        ),
        correctResult = true,
    )

    test(
        name = "when given a board with repeated number in the same row should return false",
        result = checkValidSudoku(
            listOf(
                listOf('1', '2', '1'),
                listOf('3', '1', '2'),
                listOf('2', '3', '_')
            ),
            size = 3,
        ),
        correctResult = false,
    )
    test(
        name = "when given a board with repeated number in the same column should return false",
        result = checkValidSudoku(
            listOf(
                listOf('1', '2', '3'),
                listOf('_', '1', '3'),
                listOf('2', '3', '1')
            ),
            size = 3,
        ),
        correctResult = false,
    )

    test(
        name = "when given a board with repeated number in the same box should return false",
        result = checkValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '1', '_', '2'),
                listOf('2', '_', '4', '3'),
                listOf('4', '3', '2', '1')
            ), size = 4
        ),
        correctResult = false,
    )

    test(
        name = "when given a board with a character should return false",
        result = checkValidSudoku(
            listOf(
                listOf('1', '2', '3'),
                listOf('_', '1', 'a'),
                listOf('2', '3', '1')
            ),
            size = 3,
        ),
        correctResult = false,
    )
    test(
        name = "when given a board with a space in empty field should return false",
        result = checkValidSudoku(
            listOf(
                listOf('1', '2', '3'),
                listOf(' ', '1', '2'),
                listOf('2', '3', '1')
            ),
            size = 3,
        ),
        correctResult = false,
    )
    test(
        name = "when given a board with a special character should return false",
        result = checkValidSudoku(
            listOf(
                listOf('1', '2', '3'),
                listOf('_', '1', '#'),
                listOf('2', '3', '1')
            ),
            size = 3,
        ),
        correctResult = false,
    )

    test(
        name = "when given a board with a number greater than the size should return false",
        result = checkValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '5', '_', '2'),
                listOf('2', '_', '4', '3'),
                listOf('4', '3', '2', '1')
            ), size = 4
        ),
        correctResult = false,
    )

    // try to change it to english number
    test(
        name = "when given a board with a number not written in English should return false",
        result = checkValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '٧', '_', '2'),
                listOf('2', '_', '4', '3'),
                listOf('4', '3', '2', '1')
            ), size = 4
        ),
        correctResult = false,
    )

    ///////
    test(
        name = "when given a board with zero should return false",
        result = checkValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '0', '_', '2'),
                listOf('2', '_', '4', '3'),
                listOf('4', '3', '2', '1')
            ), size = 4
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