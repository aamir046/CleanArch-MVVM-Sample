package com.example.mvvmclean.data.network.remotedatasources

import com.example.mvvmclean.data.network.apiservices.ApiServices
import com.example.mvvmclean.data.network.responses.toDomainModel
import com.example.mvvmclean.domain.iremotesource.ITopHeadlinesRemoteSource
import com.example.mvvmclean.domain.model.mainmodels.TopHeadlines
import com.example.mvvmclean.domain.model.requestmodels.TopHeadlinesRequest
import com.example.mvvmclean.domain.status.Status
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TopHeadlinesRemoteSourceImp @Inject constructor(
    private val apiService: ApiServices
) : ITopHeadlinesRemoteSource {

    override suspend fun getTopHeadlines(topHeadlinesRequest: TopHeadlinesRequest): Status<List<TopHeadlines>> {
        return try {
            Status.Success(
                apiService.getTopHeadlines(
                    topHeadlinesRequest.country,
                    topHeadlinesRequest.page,
                    topHeadlinesRequest.pageSize,
                    topHeadlinesRequest.apiKey,
                ).toDomainModel()
            )
        } catch (ex: HttpException) {
            Status.Error(ex.message(), ex.code())
        } catch (ex: IOException) {
            Status.Error(ex.message)
        }
    }

}