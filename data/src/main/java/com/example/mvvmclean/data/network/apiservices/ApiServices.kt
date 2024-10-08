package com.example.mvvmclean.data.network.apiservices

import com.example.mvvmclean.data.network.responses.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String
    ): TopHeadlinesResponse

//    @POST(Constants.ENDPOINT_SIGNUP)
//    suspend fun signUp(
//        @Body signUserData: SingupUserData
//    ): BaseResponse
}