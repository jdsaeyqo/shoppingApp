package com.example.shoppingapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.data.entity.product.ProductEntity
import com.example.shoppingapp.domain.GetProductItemUseCase
import com.example.shoppingapp.domain.OrderProductItemUseCase
import com.example.shoppingapp.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ProductDetailViewModel(
    private val productId : Long,
    private val getProductItemUseCase: GetProductItemUseCase,
    private val orderProductItemUseCase: OrderProductItemUseCase
) : BaseViewModel() {

    private var _productDetailStateLiveData = MutableLiveData<ProductDetailState>(ProductDetailState.UnInitialized)
    val productDetailStateLiveData: LiveData<ProductDetailState> = _productDetailStateLiveData

    lateinit var productEntity: ProductEntity

    override fun fetchData(): Job = viewModelScope.launch {
        setState(ProductDetailState.Loading)
        getProductItemUseCase(productId)?.let { product ->
        productEntity = product
            setState(
                ProductDetailState.Success(product)
            )
        }?: kotlin.run {
            setState(ProductDetailState.Error)
        }
    }

    fun orderProduct() = viewModelScope.launch {

        if(::productEntity.isInitialized){
            val productId = orderProductItemUseCase(productEntity)
            if(productEntity.id == productId){
                setState(ProductDetailState.Order)
            }
        }else{
            setState(ProductDetailState.Error)
        }



    }

    private fun setState(state: ProductDetailState){
        _productDetailStateLiveData.postValue(state)

    }
}