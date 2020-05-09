import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConverterTester {

    @Test
    fun testConverter_givenNumber_convertsToRomanNumerals() {
        assertEquals("I", Converter().convert(1))
    }
}