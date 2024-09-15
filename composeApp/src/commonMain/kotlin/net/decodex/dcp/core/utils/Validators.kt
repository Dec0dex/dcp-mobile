package net.decodex.dcp.core.utils

object Validators {
    fun isValidEmail(email: String): Boolean {
        val emailAddressRegex =
            Regex(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+",
            )

        return email.matches(emailAddressRegex)
    }

    fun isValidPassword(password: String): Boolean {
        val isLongEnough = password.length >= 8
        val hasEnoughDigits = password.count(Char::isDigit) > 0
        val isMixedCase = password.any(Char::isLowerCase) && password.any(Char::isUpperCase)
        val hasSpecialChar = password.any { it in " !\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~" }

        return isLongEnough && hasEnoughDigits && isMixedCase && hasSpecialChar
    }
}
