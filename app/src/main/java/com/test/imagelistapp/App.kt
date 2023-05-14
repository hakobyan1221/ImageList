package com.test.imagelistapp

import android.app.Application
import com.test.imagelistapp.di.DaggerApplicationComponent

class App : Application() {
    val appComponent = DaggerApplicationComponent.create()
}
