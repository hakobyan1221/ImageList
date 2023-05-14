package com.test.imagelistapp.data.login.repo

import com.test.imagelistapp.data.login.repo.model.LoginResponse
import com.test.imagelistapp.data.login.repo.model.SignUpResponse

interface LoginRepository {

    suspend fun login(email: String, password: String): LoginResponse

    suspend fun signUp(email: String, password: String, age: String): SignUpResponse
}
