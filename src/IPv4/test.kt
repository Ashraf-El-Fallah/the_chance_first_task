package IPv4

import checkIPv4Address

/**
After completing the instructional videos, implement an IPv4 address checker function that determines whether a given string is a valid IPv4 address.

An IPv4 address is valid if it consists of four numeric segments, separated by dots (.), where:

- Each segment must be a number between 0 and 255, inclusive.
- Leading zeros in any segment (e.g., "01" or "001") are not allowed, except for the digit "0" itself.
- The address must contain exactly three dots and no extra characters.
- The function should return a Boolean value only—true if the input is a valid IPv4 address, and false otherwise.

You must follow a Test-Driven Development (TDD) approach while building this function:

- Create a check function, follow the tutorial structure, and write comprehensive test cases first without implementing any logic in the checker function. Initially, the function should always return false.
- Share your written test cases with your mentor during the daily meeting for review and feedback.
Once approved, begin implementing the logic of the IPv4 checker function step by step, ensuring that each test passes.
- Upon successful implementation, design a complete flowchart to represent the decision-making logic of the function using draw.io.
 */
fun main() {
    test(
        name = "when given an empty address should return false",
        result = checkIPv4Address(""),
        correctResult = false
    )
    test(
        name = "when given a blank address should return false",
        result = checkIPv4Address(" "),
        correctResult = false
    )
    test(
        name = "when given an address with more than three dots should return false",
        result = checkIPv4Address("1.233.32.32."),
        correctResult = false
    )
    test(
        name = "when given an address with less than four numeric segments should return false",
        result = checkIPv4Address("1.233.32"),
        correctResult = false
    )
    test(
        name = "when given an address with more than four numeric segments should return false",
        result = checkIPv4Address("1.233.32.156.201"),
        correctResult = false
    )
    test(
        name = "when given an address with leading zeros in any segments should return false",
        result = checkIPv4Address("01.233.90.76"),
        correctResult = false
    )
    test(
        name = "when given an address with numeric segment more than 255 should return false",
        result = checkIPv4Address("1.270.11.76"),
        correctResult = false
    )

    test(
        name = "when given an address with numeric segment less than 0 should return false",
        result = checkIPv4Address("-1.210.11.76"),
        correctResult = false
    )
    test(
        name = "when given an address with a character should return false",
        result = checkIPv4Address("a.210.11.76"),
        correctResult = false
    )
    test(
        name = "when given an address with a space in any segment should return false",
        result = checkIPv4Address("50. .11.76"),
        correctResult = false
    )
    test(
        name = "when given an address missing any segment should return false",
        result = checkIPv4Address("50..11.76"),
        correctResult = false
    )

    test(
        name = "when given an address with number not written in english should return false",
        result = checkIPv4Address("210.٧.11.76"),
        correctResult = false
    )
    test(
        name = "when given an address with number not written in english should return false",
        result = checkIPv4Address("210.٧.11.76"),
        correctResult = false
    )

    test(
        name = "when given an address with a special character should return false",
        result = checkIPv4Address("50.@220.11.76"),
        correctResult = false
    )

    test(
        name = "when given a valid address should return true",
        result = checkIPv4Address("50.220.11.76"),
        correctResult = true
    )
}

fun test(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed  - $name")
    }
}