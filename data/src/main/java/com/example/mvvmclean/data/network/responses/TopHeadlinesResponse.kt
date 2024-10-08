package com.example.mvvmclean.data.network.responses

import com.example.mvvmclean.domain.model.mainmodels.TopHeadlines
import com.example.mvvmclean.domain.responses.BaseResponse
import com.google.gson.annotations.SerializedName

class TopHeadlinesResponse(

    @SerializedName("status")
    val status: String,

    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("articles")
    val articles: List<Article>
) : BaseResponse()

data class Article(
    @SerializedName("source")
    val source: Source,

    @SerializedName("author")
    val author: String?,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String?,

    @SerializedName("url")
    val url: String,

    @SerializedName("urlToImage")
    val urlToImage: String?,

    @SerializedName("publishedAt")
    val publishedAt: String,

    @SerializedName("content")
    val content: String?
)

data class Source(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String
)

fun TopHeadlinesResponse.toDomainModel(): List<TopHeadlines> {
    return articles.map {
        TopHeadlines(
            author = it.author,
            title = it.title,
            description = it.description,
            content = it.content,
            url = it.url,
            imageUrl = it.urlToImage,
            publishedAt = it.publishedAt,
            sourceName = it.source.name
        )
    }
}
