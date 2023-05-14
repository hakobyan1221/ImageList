package com.test.imagelistapp.di.login

import com.test.ui.login.LoginFragment
import com.test.ui.login.SignUpFragment
import dagger.Subcomponent

/** A subcomponent which builds a dependency tree for user login and sign up **/
@Subcomponent(modules = [LoginDataModule::class])
@LoginScope
interface LoginSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun provideFactory(): LoginSubComponent
    }

    fun inject(fragment: LoginFragment)

    fun inject(fragment: SignUpFragment)
}
