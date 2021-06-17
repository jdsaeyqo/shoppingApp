package com.example.shoppingapp.domain

import com.example.shoppingapp.data.entity.product.ProductEntity
import com.example.shoppingapp.data.repository.ProductRepository

internal class GetProductListUseCase(
    private val productRepository: ProductRepository
): UseCase {
    suspend operator fun invoke(): List<ProductEntity> {
        return productRepository.getProductList()
    }
}