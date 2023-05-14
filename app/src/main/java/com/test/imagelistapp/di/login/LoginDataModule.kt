package com.test.imagelistapp.di.login

import com.test.imagelistapp.data.login.repo.LoginRepository
import com.test.imagelistapp.data.login.repo.MockLoginRepository
import com.test.imagelistapp.di.login.LoginScope
import dagger.Binds
import dagger.Module

@LoginScope
@Module
abstract class LoginDataModule {

    @Binds
    abstract fun provideLoginRepository(repo: MockLoginRepository): LoginRepository
}
