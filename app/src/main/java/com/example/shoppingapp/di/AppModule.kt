package com.example.shoppingapp.di

import com.example.shoppingapp.data.network.buildOkHttpClient
import com.example.shoppingapp.data.network.provideGsonConverterFactory
import com.example.shoppingapp.data.network.provideProductApiService
import com.example.shoppingapp.data.network.provideProductRetrofit
import org.koin.dsl.module

val appModule = module {

    single { provideGsonConverterFactory() }

    single { buildOkHttpClient() }

    single { provideProductRetrofit(get(), get()) }

    single { provideProductApiService(get()) }
}