package com.example.mvvmclean.ui.headlinedetails

import androidx.lifecycle.MutableLiveData
import com.example.mvvmclean.base.BaseViewModel
import com.example.mvvmclean.domain.model.mainmodels.TopHeadlines

class HeadlineDetailsVM : BaseViewModel() {
    val headline = MutableLiveData<TopHeadlines>()
    var isExpanded = false
}
