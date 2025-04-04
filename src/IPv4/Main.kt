package IPv4

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

fun checkValidSudoku(board: List<List<Char>>, size: Int): Boolean {
    return true
}