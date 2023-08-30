package com.raywenderlich.android.busso.di.component

import android.app.Activity
import com.raywenderlich.android.busso.di.module.AppModule
import com.raywenderlich.android.busso.di.module.NetworkModule
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalFragment
import com.raywenderlich.android.busso.ui.view.busstop.BusStopFragment
import com.raywenderlich.android.busso.ui.view.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class,NetworkModule::class])
@Singleton
interface AppComponent {

    // 1
    @Component.Builder
    interface Builder {
        fun appModule(appModule: AppModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        @BindsInstance // 2
        fun activity(activity: Activity): Builder
        fun build(): AppComponent

    }

    fun inject(activity: Activity)
    fun inject(activity: MainActivity)
    fun inject(fragment:BusStopFragment)
    fun inject(fragment:BusArrivalFragment)
}