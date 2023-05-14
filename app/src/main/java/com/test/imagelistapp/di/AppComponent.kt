package com.test.imagelistapp.di

import com.test.imagelistapp.di.imageList.ImageListSubComponent
import com.test.imagelistapp.di.imageList.ImageListSubComponentModule
import com.test.imagelistapp.di.login.LoginSubComponent
import com.test.imagelistapp.di.login.LoginSubComponentModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LoginSubComponentModule::class, ImageListSubComponentModule::class])
interface ApplicationComponent {

    fun provideLoginSubComponent(): LoginSubComponent.Factory

    fun provideImageListSubComponent(): ImageListSubComponent.Factory
}
