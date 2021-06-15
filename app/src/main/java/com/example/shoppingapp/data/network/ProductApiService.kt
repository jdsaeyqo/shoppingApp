package com.example.shoppingapp.data.network

import com.example.shoppingapp.data.response.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {

    @GET("products")
    suspend fun getProduct() : Response<ProductResponse>

    @GET("products/{productId}")
    suspend fun getProduct(@Path("productId") production : Long) : Response<ProductResponse>
}