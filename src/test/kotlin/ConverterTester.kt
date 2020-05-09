import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ConverterTester {

    @ParameterizedTest
    @CsvSource("1, I", "2, II", "3, III", "4, IV", "5, V", "6, VI", "7, VII", "8, VII", "9, IX", "10, X")
    fun `convert number into roman numeral`(input: Int, output: String) {
        val result = Converter().convert(input)
        assertEquals(output, result)
    }
}