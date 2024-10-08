package com.example.mvvmclean.domain.model.mainmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TopHeadlines(
    val title: String,
    val description: String?,
    val content: String?,
    val author: String?,
    val url: String,
    val imageUrl: String?,
    val publishedAt: String,
    val sourceName: String
) : Parcelable