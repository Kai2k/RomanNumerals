class Converter {
    fun convert(input: Int): String {
        return convertByPosition(input)
    }

    private fun convertByPosition(number: Int): String {
        var output = ""
        var remainderToConvert = number
        while (remainderToConvert > 0) {
            val highestPosition = highestPosition(remainderToConvert)
            val countAtPosition = getCountAtPosition(remainderToConvert, highestPosition)
            output = output.plus(convertNumber(countAtPosition, highestPosition))
            remainderToConvert = remainderToConvert.minus(getSumAtPosition(countAtPosition, highestPosition))
        }
        return output
    }

    private fun highestPosition(number: Int): Position {
        val positions = Position.values()
        return positions.first { position -> position.min <= number && number <= position.max }
    }

    private fun convertNumber(number: Int, position: Position): String {
        val lowerNumeral = nextLowestNumeralForPosition(number, position) ?: position.numeralOne
        val higherNumeral = nextHighestNumeralForPosition(number, position) ?: position.numeralTen
        val matchingNumeral = matchingRomanNumeral(number, position)

        if (matchingNumeral != null) return matchingNumeral.numeral
        if (shouldSubtractFromNextHighestNumeral(number, higherNumeral.value)) return one() + higherNumeral.numeral
        return convertToNumeralsWithAddition(lowerNumeral, number, position)
    }

    private fun getCountAtPosition(number: Int, position: Position): Int {
        return number / position.min
    }

    private fun getSumAtPosition(number: Int, position: Position): Int {
        return number * position.min
    }

    private fun nextLowestNumeralForPosition(number: Int, position: Position): Numeral? {
        return if (number > 5) position.numeralFive else position.numeralOne
    }

    private fun nextHighestNumeralForPosition(number: Int, position: Position): Numeral? {
        return if (number < 5) position.numeralFive else position.numeralTen
    }

    private fun matchingRomanNumeral(number: Int, position: Position): Numeral? {
        return position.numerals().firstOrNull { numeral -> numeral.value == number }
    }

    private fun shouldSubtractFromNextHighestNumeral(number: Int, nextHighestNumeralValue: Int): Boolean {
        return nextHighestNumeralValue - number == 1
    }

    private fun convertToNumeralsWithAddition(lowerNumeral: Numeral, number: Int, position: Position): String {
        var output = lowerNumeral.numeral
        val difference = number - lowerNumeral.valueForAddition
        output += times(difference) { position.numeralOne.numeral }
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