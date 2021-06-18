package com.example.shoppingapp.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppingapp.databinding.ActivityProductDetailBinding
import com.example.shoppingapp.presentation.BaseActivity
import org.koin.android.ext.android.inject

internal class ProductDetailActivity : BaseActivity<ProductDetailViewModel,ActivityProductDetailBinding>() {

    override val viewModel by inject<ProductDetailViewModel>()

    override fun getViewBinding(): ActivityProductDetailBinding = ActivityProductDetailBinding.inflate(layoutInflater)

    override fun observeData() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}