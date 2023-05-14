package com.test.imagelistapp.domain.login

import androidx.lifecycle.*
import com.test.imagelistapp.data.login.repo.LoginRepository
import com.test.imagelistapp.di.login.LoginScope
import com.test.imagelistapp.domain.SingleLiveEvent
import com.test.imagelistapp.domain.toLoginViewData
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
) : ViewModel() {

    private val _loginData = MutableLiveData<LoginViewData>()
    val loginData: LiveData<LoginViewData> = _loginData

    // Let this be single live event to avoid multiple navigation to sign up screen
    val navigateToSignUp = SingleLiveEvent<Boolean>()

    // let's navigate to home screen if login was successful
    val navigateToHomeScreenCommand: LiveData<Boolean> = _loginData.map {
        it.isSuccess
    }

    fun onLoginClick(email: String, password: String) {
        viewModelScope.launch {
            _loginData.value = loginRepository.login(email, password).toLoginViewData()
        }
    }

    fun onSignUpClick() {
        navigateToSignUp.value = true
    }

    data class LoginViewData(
        val isSuccess: Boolean,
        val loginError: String?,
        val passwordError: String?,
    )
}
