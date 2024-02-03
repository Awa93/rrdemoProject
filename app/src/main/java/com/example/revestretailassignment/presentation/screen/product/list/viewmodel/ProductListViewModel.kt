package com.example.revestretailassignment.presentation.screen.product.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.revestretailassignment.data.network.isSuccess
import com.example.revestretailassignment.domain.model.ProductsListUIModel
import com.example.revestretailassignment.domain.usecase.ProductListUseCase
import com.example.revestretailassignment.presentation.screen.product.list.ProductListViewState
import kotlinx.coroutines.launch

class ProductListViewModel(
    private val useCase: ProductListUseCase
) : ViewModel() {

    var viewState: ProductListViewState
        private set

    init {
        viewState = ProductListViewState()
        callProductListApi()
    }

    private fun callProductListApi() {
        viewModelScope.launch {
            viewState.showLoadingIndicator.value = true
            val response = useCase.execute(null)
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

    private fun handleSuccess(data: ProductsListUIModel?) {
        data?.let {
            viewState.total = it.total
            viewState.limit = it.limit
            viewState.skip = it.skip
            viewState.isApiSuccess.value = true
            viewState.products.addAll(it.products)
        } ?: handleError("unknown error", 200)

    }
}