package com.test.imagelistapp.domain.login

import androidx.lifecycle.*
import com.test.imagelistapp.data.login.repo.LoginRepository
import com.test.imagelistapp.domain.toSignUpViewData
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
) : ViewModel() {

    private val _signUpData = MutableLiveData<SignUpViewData>()
    val signUpData: LiveData<SignUpViewData> = _signUpData

    // let's navigate to home screen if sign up was successful
    val navigateToHomeScreenCommand: LiveData<Boolean> = _signUpData.map {
        it.isSuccess
    }

    fun onSignUpClick(email: String, password: String, age: String) {
        viewModelScope.launch {
            _signUpData.value = loginRepository.signUp(email, password, age).toSignUpViewData()
        }
    }

    data class SignUpViewData(
        val isSuccess: Boolean,
        val loginError: String?,
        val passwordError: String?,
        val ageError: String?
    )
}
