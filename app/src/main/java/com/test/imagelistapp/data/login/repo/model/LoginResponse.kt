package com.test.imagelistapp.data.login.repo.model

data class LoginResponse(
    val isSuccess: Boolean,
    val loginError: String?,
    val passwordError: String?
)
