enum class Numeral(val value: Int, val numeral: String, val valueForAddition: Int) {
    ONE(1, "I", 1),
    FIVE(5, "V", 5),
    TEN(10, "X", 1),
    FIFTY(50, "L", 5),
    ONE_HUNDRED(100, "C", 1),
    FIVE_HUNDRED(500, "D", 5),
    ONE_THOUSAND(1000, "M", 1)
}