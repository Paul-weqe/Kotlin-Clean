package clean.school.validation

import java.util.regex.Pattern

class BaseValidation {

    companion object {
        fun validateEmail(email: String) : Boolean {
            val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
            val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(email)
            return matcher.matches()
        }

        fun validateInputContainsSpecialCharacter(input: String) : Boolean {
            val expression = "[!@#$%&*()_+=|<>?{}\\[\\]~-]"
            val pattern = Pattern.compile(expression)
            val matcher  = pattern.matcher(input)
            return matcher.find()
        }
    }

}