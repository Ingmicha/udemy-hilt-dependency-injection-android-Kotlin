package com.ingmicha.android.compose.hilt.hilt

import com.ingmicha.android.compose.hilt.network.CallInterceptorImpl
import com.ingmicha.android.compose.hilt.network.NetworkService
import com.ingmicha.android.compose.hilt.network.ResponseInterceptorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewComponent

@Module
@InstallIn(ActivityComponent::class, ViewComponent::class)
class NetworkModule {

//    @Binds
//    abstract fun bindNetworkAdapterImpl(networkAdapterImpl: MyNetworkAdapter):
//            NetworkAdapter


//    @Provides
//    fun provideNetworkService(): NetworkService = NetworkService.Builder()
//        .host("google.com")
//        .protocol("https")
//        .build()

    @CallInterceptor
    @Provides
    fun provideCallNetworkService(): NetworkService =
        NetworkService.Builder()
            .host("google.com")
            .protocol("https")
            .interceptor(CallInterceptorImpl())
            .build()

    @ResponseInterceptor
    @Provides
    fun providesResponseNetworkService(): NetworkService =
        NetworkService.Builder()
            .host("google.com")
            .protocol("https")
            .interceptor(ResponseInterceptorImpl())
            .build()


}