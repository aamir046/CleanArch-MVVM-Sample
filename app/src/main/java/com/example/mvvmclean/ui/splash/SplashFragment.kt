package com.example.mvvmclean.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mvvmclean.BR
import com.example.mvvmclean.R
import com.example.mvvmclean.base.BaseFragment
import com.example.mvvmclean.base.NavigationCommand
import com.example.mvvmclean.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashVM>(){

    private val mainViewModel: SplashVM by viewModels()

    override val bindingVariable: Int = _root_ide_package_.com.example.mvvmclean.BR.viewModel

    override val layoutId: Int = R.layout.fragment_splash

    override val viewModel: SplashVM by lazy { mainViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            navigateToTargetScreen()
        }
    }

    private suspend fun navigateToTargetScreen(){

        withContext(Dispatchers.IO){
            delay(2000)
        }

//        if(!viewModel.isFirstTimeLogin){
//            navigate(
//                NavigationCommand.To(
//                    SplashFragmentDirections.toIntroFragment()
//                )
//            )
//        }else{
            navigate(
                NavigationCommand.To(
                    SplashFragmentDirections.toTopHeadLinesFragment()
                )
            )
      //  }
    }

}