package com.example.mvvmclean.domain.iremotesource

import com.example.mvvmclean.domain.model.mainmodels.TopHeadlines
import com.example.mvvmclean.domain.model.requestmodels.TopHeadlinesRequest
import com.example.mvvmclean.domain.status.Status


interface ITopHeadlinesRemoteSource {
    suspend fun getTopHeadlines(topHeadlinesRequest: TopHeadlinesRequest): Status<List<TopHeadlines>>
}