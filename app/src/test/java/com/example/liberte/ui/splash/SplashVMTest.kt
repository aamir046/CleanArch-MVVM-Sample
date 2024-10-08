package com.example.liberte.ui.splash

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.liberte.ui.CoroutineRule
import com.example.mvvmclean.ui.splash.SplashVM
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
internal class SplashVMTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = CoroutineRule()

    lateinit var sut: SplashVM
//
//    @Before
//    fun setUp() {
//        MockKAnnotations.init(this)
//    }
//
//    @After
//    fun clear() {
//        clearAllMocks()
//    }
//
//
//    @Test
//    fun check_mapping_article_to_article_Data_Item_test() {
//        sut = SplashVM(mockk(relaxed = true))
//        sut.mapArticlesDataItem(DataFactory.getDummyArticleList())
//        Assert.assertEquals(2, sut.articlesLiveDataLiveData.value?.size)
//    }
//
//    @Test
//    fun get_articles_success_test() {
//        val articleRepository = mockk<SignUpRepositoryImpl> {
//            coEvery { getArticles(7) } returns
//                    Status.Success(DataFactory.getDummyArticleList())
//        }
//
//        val signUpUseCase = SignUpUseCase(articleRepository)
//        sut = SplashVM(signUpUseCase)
//
//        Assert.assertNotNull(sut.fetchArticles(7))
//        Assert.assertEquals(2, sut.articlesLiveDataLiveData.value?.size)
//    }
//
//    @Test
//    fun get_articles_API_failed_test() {
//        val articleRepository = mockk<SignUpRepositoryImpl> {
//            coEvery { getArticles(7) } returns
//                    Status.Error("Api Error message: internal server error",501)
//        }
//
//        val signUpUseCase = SignUpUseCase(articleRepository)
//        sut = SplashVM(signUpUseCase)
//
//        sut.fetchArticles(7)
//
//        Assert.assertNull(sut.articlesLiveDataLiveData.value)
//    }

}