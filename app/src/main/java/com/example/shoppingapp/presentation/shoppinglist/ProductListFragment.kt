package com.example.shoppingapp.presentation.shoppinglist

import com.example.shoppingapp.databinding.FragmentProductListBinding
import com.example.shoppingapp.presentation.BaseFragment
import org.koin.android.ext.android.inject

internal class ProductListFragment : BaseFragment<ProductListViewModel,FragmentProductListBinding>() {

    companion object{
        const val TAG = "ProductListFragment"
    }

    override val viewModel by inject<ProductListViewModel>()

    override fun getViewBinding(): FragmentProductListBinding = FragmentProductListBinding.inflate(layoutInflater)

    override fun observeData() {
    }
}