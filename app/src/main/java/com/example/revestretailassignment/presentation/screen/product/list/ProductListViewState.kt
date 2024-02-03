package com.example.revestretailassignment.presentation.screen.product.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.revestretailassignment.application.AppConstant.EMPTY
import com.example.revestretailassignment.domain.model.Product

data class ProductListViewState(
    val image: MutableState<String> = mutableStateOf(EMPTY),
    val isApiSuccess: MutableState<Boolean> = mutableStateOf(false),
    val showLoadingIndicator: MutableState<Boolean> = mutableStateOf(false),
    val apiErrorMessage: MutableState<String> = mutableStateOf(EMPTY),
    val products: MutableList<Product> = mutableListOf(),
    var total: Int = 0,
    var skip: Int = 0,
    var limit: Int = 0
)