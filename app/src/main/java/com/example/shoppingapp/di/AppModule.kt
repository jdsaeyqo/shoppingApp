package com.example.shoppingapp.di

import com.example.shoppingapp.data.db.provideDB
import com.example.shoppingapp.data.db.provideToDoDao
import com.example.shoppingapp.data.network.buildOkHttpClient
import com.example.shoppingapp.data.network.provideGsonConverterFactory
import com.example.shoppingapp.data.network.provideProductApiService
import com.example.shoppingapp.data.network.provideProductRetrofit
import com.example.shoppingapp.data.preference.PreferenceManager
import com.example.shoppingapp.data.repository.DefaultProductRepository
import com.example.shoppingapp.data.repository.ProductRepository
import com.example.shoppingapp.domain.GetProductItemUseCase
import com.example.shoppingapp.domain.GetProductListUseCase
import com.example.shoppingapp.domain.OrderProductItemUseCase
import com.example.shoppingapp.presentation.detail.ProductDetailViewModel
import com.example.shoppingapp.presentation.main.MainViewModel
import com.example.shoppingapp.presentation.profile.ProfileViewModel
import com.example.shoppingapp.presentation.shoppinglist.ProductListViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {


    // Coroutines Dispatcher
    single { Dispatchers.IO }
    single { Dispatchers.Main }

    //ViewModel
    viewModel{ MainViewModel() }
    viewModel { ProductListViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { (productId : Long) -> ProductDetailViewModel(productId,get(),get()) }

    //Repositories
    single<ProductRepository> { DefaultProductRepository(get(), get(),get()) }

    //UseCases
    factory { GetProductItemUseCase(get()) }
    factory { GetProductListUseCase(get()) }
    factory { OrderProductItemUseCase(get()) }

    //Repository
    single { provideGsonConverterFactory() }

    single { buildOkHttpClient() }

    single { provideProductRetrofit(get(), get()) }

    single { provideProductApiService(get()) }

    single { PreferenceManager(androidContext()) }

    //Database
    single { provideDB(androidApplication()) }
    single { provideToDoDao(get())}

}