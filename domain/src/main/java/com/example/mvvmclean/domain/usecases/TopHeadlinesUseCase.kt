package com.example.mvvmclean.domain.usecases

import com.example.mvvmclean.domain.irepository.ITopHeadLinesRepoSource
import com.example.mvvmclean.domain.model.mainmodels.TopHeadlines
import com.example.mvvmclean.domain.model.requestmodels.TopHeadlinesRequest
import com.example.mvvmclean.domain.status.Status
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class TopHeadlinesUseCase @Inject constructor(
    private val iTopHeadLinesRepoSource: ITopHeadLinesRepoSource) {

    suspend fun getTopHeadlines(topHeadlinesRequest: TopHeadlinesRequest): Status<List<TopHeadlines>> = iTopHeadLinesRepoSource.getTopHeadlines(topHeadlinesRequest)

}