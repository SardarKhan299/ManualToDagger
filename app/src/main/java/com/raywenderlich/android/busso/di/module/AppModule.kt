package com.raywenderlich.android.busso.di.module

import android.app.Activity
import android.content.Context
import android.location.Location
import android.location.LocationManager
import com.raywenderlich.android.busso.permission.GeoLocationPermissionCheckerImpl
import com.raywenderlich.android.busso.ui.view.main.MainPresenter
import com.raywenderlich.android.busso.ui.view.main.MainPresenterImpl
import com.raywenderlich.android.busso.ui.view.splash.SplashPresenter
import com.raywenderlich.android.busso.ui.view.splash.SplashPresenterImpl
import com.raywenderlich.android.busso.ui.view.splash.SplashViewBinder
import com.raywenderlich.android.busso.ui.view.splash.SplashViewBinderImpl
import com.raywenderlich.android.location.api.model.LocationEvent
import com.raywenderlich.android.location.rx.provideRxLocationObservable
import com.raywenderlich.android.ui.navigation.Navigator
import com.raywenderlich.android.ui.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

@Module(includes = [AppModule.Bindings::class])
class AppModule(private val activity: Activity) {

    @Provides
    fun getLocationObservable():Observable<LocationEvent>{
        // 3
        val locationManager = activity.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        // 4
        val geoLocationPermissionChecker = GeoLocationPermissionCheckerImpl(activity)
        // 5
        return provideRxLocationObservable(locationManager, geoLocationPermissionChecker)
    }

    @Provides
    fun getNavigatorObject():Navigator{
        return NavigatorImpl(activity)
    }

    // 2
    @Module
    interface Bindings {
        // 3
        @Binds
        fun bindSplashPresenter(impl: SplashPresenterImpl): SplashPresenter
        // 4
        @Binds
        fun bindSplashViewBinder(impl: SplashViewBinderImpl): SplashViewBinder

        @Binds
        fun bindMainPresenter(impl: MainPresenterImpl): MainPresenter


    }


}