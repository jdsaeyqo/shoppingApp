package com.example.shoppingapp.di

import com.example.shoppingapp.data.network.buildOkHttpClient
import com.example.shoppingapp.data.network.provideGsonConverterFactory
import com.example.shoppingapp.data.network.provideProductApiService
import com.example.shoppingapp.data.network.provideProductRetrofit
import com.example.shoppingapp.data.repository.DefaultProductRepository
import com.example.shoppingapp.data.repository.ProductRepository
import com.example.shoppingapp.domain.GetProductItemUseCase
import com.example.shoppingapp.presentation.main.MainViewModel
import com.example.shoppingapp.presentation.profile.ProfileViewModel
import com.example.shoppingapp.presentation.shoppinglist.ProductListViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {


    // Coroutines Dispatcher
    single { Dispatchers.IO }

    //ViewModel
    viewModel{ MainViewModel() }
    viewModel { ProductListViewModel() }
    viewModel { ProfileViewModel() }

    //Repositories
    single<ProductRepository> { DefaultProductRepository(get(), get()) }

    //UseCases
    factory { GetProductItemUseCase(get()) }

    single { provideGsonConverterFactory() }

    single { buildOkHttpClient() }

    single { provideProductRetrofit(get(), get()) }

    single { provideProductApiService(get()) }
}