package com.example.mvvmclean.data.network.di

import com.example.mvvmclean.data.network.remotedatasources.TopHeadlinesRemoteSourceImp
import com.example.mvvmclean.domain.iremotesource.ITopHeadlinesRemoteSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteSourceBinderModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTopHeadlinesRemoteSource(
        topHeadlinesRemoteSourceImp: TopHeadlinesRemoteSourceImp
    ): ITopHeadlinesRemoteSource

}
