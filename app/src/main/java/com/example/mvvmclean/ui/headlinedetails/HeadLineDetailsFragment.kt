package com.example.mvvmclean.ui.headlinedetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mvvmclean.R
import com.example.mvvmclean.base.BaseFragment
import com.example.mvvmclean.databinding.FragmentHeadlineDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeadLineDetailsFragment : BaseFragment<FragmentHeadlineDetailsBinding, HeadlineDetailsVM>() {
    private val vm: HeadlineDetailsVM by viewModels()
    private val headlineDetailsVM: HeadlineDetailsVM by lazy { vm }

    override val bindingVariable: Int
        get() = _root_ide_package_.com.example.mvvmclean.BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_headline_details

    override val viewModel: HeadlineDetailsVM by lazy { headlineDetailsVM }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args: HeadLineDetailsFragmentArgs by navArgs()
        viewModel.headline.postValue(args.headline)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        setObservables()
    }

    private fun setUpUI() {}

    private fun setObservables() {}

}