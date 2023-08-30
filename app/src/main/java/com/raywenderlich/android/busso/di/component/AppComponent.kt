package com.raywenderlich.android.busso.di.component

import android.app.Activity
import com.raywenderlich.android.busso.di.module.AppModule
import com.raywenderlich.android.busso.ui.view.main.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: Activity)
    fun inject(activity: MainActivity)
}