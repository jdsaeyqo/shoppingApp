package com.example.shoppingapp.presentation.profile

import com.example.shoppingapp.databinding.FragmentProductListBinding
import com.example.shoppingapp.databinding.FragmentProfileBinding
import com.example.shoppingapp.presentation.BaseFragment
import com.example.shoppingapp.presentation.shoppinglist.ProductListViewModel
import org.koin.android.ext.android.inject

internal class ProfileFragment : BaseFragment<ProfileViewModel,FragmentProfileBinding>() {

    companion object{
        const val TAG = "ProfileFragment"
    }

    override val viewModel by inject<ProfileViewModel>()

    override fun getViewBinding(): FragmentProfileBinding = FragmentProfileBinding.inflate(layoutInflater)

    override fun observeData() {
    }
}