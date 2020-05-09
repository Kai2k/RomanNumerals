import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ConverterTester {

    @ParameterizedTest
    @CsvSource("1, I", "2, II", "3, III", "4, IV", "5, V", "6, VI", "7, VII", "8, VIII", "9, IX", "10, X")
    fun `convert numbers 1 - 10 into roman numeral`(input: Int, output: String) {
        val result = Converter().convert(input)
        assertEquals(output, result)
    }

    @ParameterizedTest
    @CsvSource("11, XI", "12, XII", "13, XIII", "14, XIV", "15, XV", "16, XVI", "17, XVII", "18, XVIII", "19, XIX", "20, XX")
    fun `convert numbers 11 - 20 into roman numeral`(input: Int, output: String) {
        val result = Converter().convert(input)
        assertEquals(output, result)
    }

    @ParameterizedTest
    @CsvSource("21, XXI", "39, XXXIX", "75, LXXV", "100, C", "213, CCXIII", "999, CMXCIX", "555, DLV")
    fun `convert numbers greater than 20 into roman numeral`(input: Int, output: String) {
        val result = Converter().convert(input)
        assertEquals(output, result)
    }
}