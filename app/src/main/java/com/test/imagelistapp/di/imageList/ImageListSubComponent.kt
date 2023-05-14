package com.test.imagelistapp.di.imageList

import com.test.ui.home.HomeFragment
import dagger.Subcomponent

/** A subcomponent which builds a dependency tree for image list **/
@Subcomponent(modules = [ImageListDataModule::class, ImageListNetworkModule::class])
@ImageListScope
interface ImageListSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun provideFactory(): ImageListSubComponent
    }

    fun inject(fragment: HomeFragment)
}
