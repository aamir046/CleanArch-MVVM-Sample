package com.example.mvvmclean.ui.headlines

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmclean.BR
import com.example.mvvmclean.R
import com.example.mvvmclean.base.BaseFragment
import com.example.mvvmclean.base.BaseItemListener
import com.example.mvvmclean.base.NavigationCommand
import com.example.mvvmclean.databinding.FragmentHeadlinesBinding
import com.example.mvvmclean.ui.headlines.adapter.HeadlinesAdapter
import com.example.mvvmclean.ui.splash.SplashFragmentDirections
import com.example.mvvmclean.domain.model.mainmodels.TopHeadlines
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopHeadLinesFragment : BaseFragment<FragmentHeadlinesBinding, TopHeadlinesVM>(),BaseItemListener<TopHeadlines> {
    private val vm: TopHeadlinesVM by viewModels()
    private val topHeadlinesVM: TopHeadlinesVM by lazy { vm }
    private lateinit var headlinesAdapter: HeadlinesAdapter
    override val bindingVariable: Int
        get() = _root_ide_package_.com.example.mvvmclean.BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_headlines

    override val viewModel: TopHeadlinesVM by lazy { topHeadlinesVM }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchNews()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        setObservables()
    }

    private fun setUpUI() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        headlinesAdapter = HeadlinesAdapter(requireContext(), arrayListOf(),this)
        getViewDataBinding().rvHeadlines.adapter = headlinesAdapter
    }

    private fun setObservables() {
        setTopHeadLinesObserver()
    }

    private fun setTopHeadLinesObserver() {
        viewModel.topHeadlines.observe(viewLifecycleOwner, Observer { headLines ->
            //getViewDataBinding().progressBar.visibility = View.GONE
            headLines?.let {
                if (it.isNotEmpty()) {
                    headlinesAdapter.addItems(it)
                }
            }
        })
    }

    override fun onItemClick(item: TopHeadlines) {
        navigate(
          NavigationCommand.To(
              TopHeadLinesFragmentDirections.toHeadlinesDetailsFragment(item)
          )
        )
    }

}