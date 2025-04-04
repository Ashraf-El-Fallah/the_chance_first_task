fun main() {

}

fun checkIPv4Address(input: String): Boolean {
    val parts = input.split(".")
    if (parts.size != 4) return false
    for (part in parts) {
        if (part.any { it.isArabicDigit() } || part.isEmpty() || !part.all { it.isDigit() }) return false
        val tempIntPart = part.toInt()
        if (tempIntPart < 0 || tempIntPart > 255 || (part.length > 1 && part[0] == '0')) return false
    }
    return true
}

fun Char.isArabicDigit(): Boolean {
    return this in '\u0660'..'\u0669'
}

fun checkValidSudoku(board: List<List<Char>>): Boolean {
    if (board.size != 9 || board.any { it.size != 9 }) return false
    val rows = Array(9) { mutableSetOf<Char>() }
    val columns = Array(9) { mutableSetOf<Char>() }
    val box = Array(9) { mutableSetOf<Char>() }

    for (row in 0..<9) {
        for (column in 0..<9) {
            val num = board[row][column]
            if (num != '_') {
                if (num !in '1'..'9') return false
                val boxIndex = (row / 3) * 3 + (column / 3)
                if (!rows[row].add(num) || !columns[column].add(num) || !box[boxIndex].add(num)) return false

            }
        }
    }
    return true
}