package com.test.imagelistapp.data.login.repo

import com.test.imagelistapp.data.login.repo.model.LoginResponse
import com.test.imagelistapp.data.login.repo.model.SignUpResponse
import javax.inject.Inject

/** Mock repository for login and sign up which imitates backend calls and performs data validation locally**/
class MockLoginRepository @Inject constructor() : LoginRepository {
    override suspend fun login(email: String, password: String): LoginResponse {
        // let's assume that these checks happen at backend side
        return LoginResponse(
            isEmailValid(email) && isPasswordValid(password),
            EMAIL_ERROR_MESSAGE.takeIf { !isEmailValid(email) },
            PASSWORD_ERROR_MESSAGE.takeIf { !isPasswordValid(password) }
        )
    }

    override suspend fun signUp(email: String, password: String, age: String): SignUpResponse {
        return SignUpResponse(
            isEmailValid(email) && isPasswordValid(password) && isAgeValid(age),
            EMAIL_ERROR_MESSAGE.takeIf { !isEmailValid(email) },
            PASSWORD_ERROR_MESSAGE.takeIf { !isPasswordValid(password) },
            AGE_ERROR_MESSAGE.takeIf { !isAgeValid(age) }
        )
    }

    private fun isEmailValid(email: String) =
        email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isPasswordValid(password: String) = password.isNotEmpty()
            && password.length in VALID_PASS_MIN_LENGTH..VALID_PASS_MAX_LENGTH

    private fun isAgeValid(age: String) = age.toIntOrNull()?.let { it in MIN_AGE..MAX_AGE } ?: false

    companion object {
        private const val MIN_AGE = 18
        private const val MAX_AGE = 99
        private const val VALID_PASS_MIN_LENGTH = 6
        private const val VALID_PASS_MAX_LENGTH = 12
        private const val EMAIL_ERROR_MESSAGE = "Please,provide correct email address"
        private const val PASSWORD_ERROR_MESSAGE =
            "Password should contain from $VALID_PASS_MIN_LENGTH to $VALID_PASS_MAX_LENGTH symbols"
        private const val AGE_ERROR_MESSAGE = "Age should be from $MIN_AGE to $MAX_AGE"
    }
}
