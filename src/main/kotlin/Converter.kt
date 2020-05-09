import javafx.geometry.Pos

class Converter {
    fun convert(input: Int): String {
        return convertNumber(input)
    }

    private fun highestPosition(number: Int): Position {
        val positions = Position.values()
        return positions.first { position -> position.min <= number && number <= position.max }
    }

    private fun foo(number: Int) {
        val highestPosition = highestPosition(number)
    }

    private fun getSumAtPosition(number: Int, position: Position): Int {
        return number * position.min
    }

    private fun convertNumber(number: Int): String {
        val lowerNumeral = nextLowestNumeralForPosition(number, Position.ONE) ?: Numeral.ONE
        val higherNumeral = nextHighestNumeralForPosition(number, Position.ONE) ?: Numeral.ONE_HUNDRED
        val matchingNumeral = matchingRomanNumeral(number)

        if (matchingNumeral != null) return matchingNumeral.numeral
        if (shouldSubtractFromNextHighestNumeral(number, higherNumeral.value)) return one() + higherNumeral.numeral
        return convertToNumeralsWithAddition(lowerNumeral, number)
    }

    private fun nextLowestNumeral(number: Int): Numeral? {
        val numerals = Numeral.values()
        numerals.reverse()
        return numerals.firstOrNull { numeral -> number > numeral.value }
    }

    private fun nextLowestNumeralForPosition(number: Int, position: Position): Numeral? {
        return if (number > 5) position.numeralFive else position.numeralOne
    }

    private fun nextHighestNumeral(number: Int): Numeral? {
        return Numeral.values().firstOrNull { numeral -> number < numeral.value }
    }

    private fun nextHighestNumeralForPosition(number: Int, position: Position): Numeral? {
        return if (number < 5) position.numeralFive else position.numeralTen
    }

    private fun matchingRomanNumeral(number: Int): Numeral? {
        return Numeral.values().firstOrNull { numeral -> numeral.value == number }
    }

    private fun shouldSubtractFromNextHighestNumeral(number: Int, nextHighestNumeralValue: Int): Boolean {
        return nextHighestNumeralValue - number == 1
    }

    private fun convertToNumeralsWithAddition(lowerNumeral: Numeral, number: Int): String {
        var output = lowerNumeral.numeral
        val difference = number - lowerNumeral.value
        output += times(difference) { one() }
        return output
    }

    private fun times(times: Int = 1, completion: () -> String): String {
        var output = ""
        for (i in 1..times) {
            output += completion()
        }
        return output
    }

    private fun one(): String {
        return Numeral.ONE.numeral
    }
}