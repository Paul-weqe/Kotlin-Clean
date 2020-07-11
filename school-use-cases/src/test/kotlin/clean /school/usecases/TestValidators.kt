package clean.school.usecases

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import clean.school.validation.BaseValidation

class TestValidators {

    @Test
    fun testEmailValidatorWithValidEmail(){
        val isValidEmail = BaseValidation.validateEmail("paul@gmail.com")
        assertEquals(isValidEmail, true)
    }

    @Test 
    fun testEmailValidatorWIthInvalidEmail(){
        val isValidEmail = BaseValidation.validateEmail("thisisinvalid@sad")
        assertEquals(isValidEmail, false)
    }

    @Test
    fun testContainsSpecialCharacterValidatorWithStringContainingSpecialCharacter(){
        val containsSpecialCharacter = BaseValidation.validateInputContainsSpecialCharacter("c0nt@!n5")
        assertEquals(containsSpecialCharacter, true)
    }

    @Test
    fun testContainsSpecialCharacterValidatorWithStringNotContainingSpecialCharacter(){
        val containsSpecialCharacter = BaseValidation.validateInputContainsSpecialCharacter("contains")
        assertEquals(containsSpecialCharacter, false)
    }
}