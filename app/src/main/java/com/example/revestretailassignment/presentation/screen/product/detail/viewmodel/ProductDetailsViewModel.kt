package com.example.revestretailassignment.presentation.screen.product.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.revestretailassignment.data.network.isSuccess
import com.example.revestretailassignment.domain.model.Product
import com.example.revestretailassignment.domain.usecase.ProductDetailsUseCase
import com.example.revestretailassignment.presentation.screen.product.detail.ProductDetailViewState
import kotlinx.coroutines.launch

class ProductDetailsViewModel(private val useCase: ProductDetailsUseCase):ViewModel() {

        var viewState: ProductDetailViewState
            private set

        init {
            viewState = ProductDetailViewState()
        }

    fun callProductDetailApi(productId: Int) {
            viewModelScope.launch {
                viewState.showLoadingIndicator.value = true
                val response = useCase.execute(productId.toString())
                viewState.showLoadingIndicator.value =  false
                if (response.isSuccess) {
                    handleSuccess(response.data)
                } else {
                    handleError(response.message, response.code)
                }
            }

        }

        private fun handleError(message: String, code: Int) {
            viewState.apiErrorMessage.value = message
            viewState.isApiSuccess.value = false
        }

        private fun handleSuccess(data: Product?) {
            data?.let {
                viewState.isApiSuccess.value = true
                viewState.product = data
            } ?: handleError("unknown error", 200)

        }
    }