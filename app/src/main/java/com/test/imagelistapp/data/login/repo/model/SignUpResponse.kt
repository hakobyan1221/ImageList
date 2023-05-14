package com.test.imagelistapp.data.login.repo.model

data class SignUpResponse(
    val isSuccess: Boolean,
    val loginError: String?,
    val passwordError: String?,
    val ageError: String?
)
