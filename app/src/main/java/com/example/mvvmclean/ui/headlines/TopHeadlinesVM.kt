package com.example.mvvmclean.ui.headlines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmclean.base.BaseViewModel
import com.example.mvvmclean.data.common.constants.Constants
import com.example.mvvmclean.domain.model.mainmodels.TopHeadlines
import com.example.mvvmclean.domain.model.requestmodels.TopHeadlinesRequest
import com.example.mvvmclean.domain.status.Status
import com.example.mvvmclean.domain.usecases.TopHeadlinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesVM @Inject constructor(
    private val topHeadlinesUseCase: TopHeadlinesUseCase
) : BaseViewModel() {
    private val _topHeadlines = MutableLiveData<List<TopHeadlines>>()
    val topHeadlines: LiveData<List<TopHeadlines>> get() = _topHeadlines

    private var currentPage = 1

    fun fetchNews() {
        viewModelScope.launch {
            try {
                val result = topHeadlinesUseCase.getTopHeadlines(
                    TopHeadlinesRequest(
                        country = "us",
                        page = currentPage,
                        pageSize = 20,
                        apiKey = Constants.NEWS_DEMO_API_KEY
                    )
                )
                when (result) {
                    is Status.Success -> {
                        _topHeadlines.postValue(result.data ?: emptyList())
                        currentPage++
                    }

                    else -> {
                        showToast.value = "Something Went Wrong"
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
