package com.example.mvvmclean.data.network.di

import com.example.mvvmclean.data.repository.TopHeadLinesRepoSourceImpl
import com.example.mvvmclean.domain.irepository.ITopHeadLinesRepoSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoBinderModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTopHeadlinesRepository(
        topHeadLinesRepoSourceImpl: TopHeadLinesRepoSourceImpl
    ): ITopHeadLinesRepoSource

}
