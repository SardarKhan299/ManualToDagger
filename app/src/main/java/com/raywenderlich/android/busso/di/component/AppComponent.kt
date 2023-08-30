package com.raywenderlich.android.busso.di.component

import android.app.Activity
import com.raywenderlich.android.busso.di.module.AppModule
import com.raywenderlich.android.busso.di.module.NetworkModule
import com.raywenderlich.android.busso.ui.view.busstop.BusStopFragment
import com.raywenderlich.android.busso.ui.view.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class,NetworkModule::class])
@Singleton
interface AppComponent {
    fun inject(activity: Activity)
    fun inject(activity: MainActivity)
    fun inject(fragment:BusStopFragment)
}