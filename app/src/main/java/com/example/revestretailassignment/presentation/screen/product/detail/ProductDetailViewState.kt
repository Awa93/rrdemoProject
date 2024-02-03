package com.example.revestretailassignment.presentation.screen.product.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.revestretailassignment.application.AppConstant
import com.example.revestretailassignment.domain.model.Product
import com.example.revestretailassignment.domain.model.getEmptyProduct

data class ProductDetailViewState(
    val image: MutableState<String> = mutableStateOf(AppConstant.EMPTY),
    val isApiSuccess: MutableState<Boolean> = mutableStateOf(false),
    val showLoadingIndicator: MutableState<Boolean> = mutableStateOf(false),
    val apiErrorMessage: MutableState<String> = mutableStateOf(AppConstant.EMPTY),
    var product:Product =  getEmptyProduct(),
    var total: Int = 0,
    var skip: Int = 0,
    var limit: Int = 0
)