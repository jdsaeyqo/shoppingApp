package com.example.shoppingapp.data.response

data class ProductsResponse(
    val items : List<ProductResponse>,
    val count : Int
)
