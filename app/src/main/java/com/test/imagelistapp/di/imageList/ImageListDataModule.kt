package com.test.imagelistapp.di.imageList

import com.test.imagelistapp.data.imageList.remote.ImageRepository
import com.test.imagelistapp.data.imageList.remote.ImageRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ImageListDataModule {

    @Binds
    @ImageListScope
    abstract fun provideImageListRepo(repo: ImageRepositoryImpl): ImageRepository
}
