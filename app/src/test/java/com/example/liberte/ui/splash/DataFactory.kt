package com.example.liberte.ui.splash

import com.example.mvvmclean.domain.model.mainmodels.Article

object DataFactory {

    fun getDummyArticleList(): List<Article> {
        return listOf<Article>(
            Article(
                1,
                "https:testingURL.com",
                "Testing",
                "type",
                "Testing Success Result",
                "",
                "20-10-2022",
                listOf()
            ),
            Article(
                2,
                "https:testingURL.com",
                "Testing",
                "type",
                "Testing Success Result",
                "",
                "20-10-2022",
                listOf()
            )
        )
    }
}
