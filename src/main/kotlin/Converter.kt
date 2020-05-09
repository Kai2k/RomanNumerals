class Converter {
    fun convert(input: Int): String {
        return convertOnes(input)
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

    private fun five(): String {
        return Numeral.FIVE.numeral
    }

    private fun ten(): String {
        return Numeral.TEN.numeral
    }

    private fun convertOnes(number: Int): String {
        val lowerNumeral = nextLowestNumeral(number)
        val higherNumeral = nextHighestNumeral(number)
        val matchingNumeral = matchingRomanNumeral(number)

        if (matchingNumeral != null) return matchingNumeral.numeral

        if (shouldSubtractFromNextHighestNumeral(number, higherNumeral.value)) {
            return one() + higherNumeral.numeral
        }
        var output = lowerNumeral.numeral
        val difference = number - lowerNumeral.value
        output += times(difference) { one() }
        return output
    }

    private fun matchingRomanNumeral(number: Int): Numeral? {
        return Numeral.values().firstOrNull { numeral -> numeral.value == number }
    }

    private fun shouldSubtractFromNextHighestNumeral(number: Int, nextHighestNumeralValue: Int): Boolean {
        return nextHighestNumeralValue - number == 1
    }

    private fun nextHighestNumeral(number: Int): Numeral {
        if (number < Numeral.FIVE.value) return Numeral.FIVE
        if (number < Numeral.TEN.value) return Numeral.TEN
        if (number < Numeral.FIFTY.value) return Numeral.FIFTY
        return Numeral.ONE_HUNDRED
    }

    private fun nextLowestNumeral(number: Int): Numeral {
        if (number > Numeral.FIFTY.value) return Numeral.FIFTY
        if (number > Numeral.TEN.value) return Numeral.TEN
        if (number > Numeral.FIVE.value) return Numeral.FIVE
        return Numeral.ONE
    }
}