package com.example.mvvmclean.data.repository

import com.example.mvvmclean.domain.iremotesource.ITopHeadlinesRemoteSource
import com.example.mvvmclean.domain.irepository.ITopHeadLinesRepoSource
import com.example.mvvmclean.domain.model.mainmodels.TopHeadlines
import com.example.mvvmclean.domain.model.requestmodels.TopHeadlinesRequest
import com.example.mvvmclean.domain.status.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TopHeadLinesRepoSourceImpl @Inject constructor(
    private val remoteSource: ITopHeadlinesRemoteSource
):ITopHeadLinesRepoSource{

    override suspend fun getTopHeadlines(topHeadlinesRequest: TopHeadlinesRequest): Status<List<TopHeadlines>> {
      return withContext(Dispatchers.IO) {remoteSource.getTopHeadlines(topHeadlinesRequest)}
    }

}