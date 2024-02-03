package com.example.revestretailassignment.di.viewmodel

import com.example.revestretailassignment.presentation.screen.product.detail.viewmodel.ProductDetailsViewModel
import com.example.revestretailassignment.presentation.screen.product.list.viewmodel.ProductListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelDependency = module {
    viewModel { ProductListViewModel(get()) }
    viewModel { ProductDetailsViewModel(get()) }
}