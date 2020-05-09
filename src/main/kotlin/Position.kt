enum class Position(val min: Int, val max: Int, val numeralOne: Numeral, val numeralFive: Numeral, val numeralTen: Numeral) {
    ONE(1, 9, Numeral.ONE,  Numeral.FIVE, Numeral.TEN),
    TEN(10, 99, Numeral.TEN, Numeral.FIFTY, Numeral.ONE_HUNDRED)
}