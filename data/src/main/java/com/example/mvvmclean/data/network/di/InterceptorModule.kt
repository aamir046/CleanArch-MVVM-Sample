package com.example.mvvmclean.data.network.di

import com.example.mvvmclean.data.network.interceptors.CacheInterceptor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CacheDataInterceptor

@Module
@InstallIn(SingletonComponent::class)
abstract class InterceptorModule {

    @CacheDataInterceptor
    @Binds
    abstract fun provideCacheDataInterceptor(interceptor: CacheInterceptor): Interceptor
}