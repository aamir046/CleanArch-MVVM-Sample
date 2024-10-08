package com.example.mvvmclean.domain.model.requestmodels

data class TopHeadlinesRequest (
    val country: String,
    val page: Int,
    val pageSize: Int = 20,
    val apiKey: String
)

