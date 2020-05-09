import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ConverterTester {

    @ParameterizedTest
    @CsvSource("1, I")
    fun `convert number into roman numeral`(input: Int, output: String) {
        val result = Converter().convert(input)
        assertEquals(output, result)
    }
}