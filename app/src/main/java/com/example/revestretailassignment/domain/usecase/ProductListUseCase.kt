package com.example.revestretailassignment.domain.usecase

import com.example.revestretailassignment.data.network.RRApiResult
import com.example.revestretailassignment.domain.model.ProductsListUIModel
import com.example.revestretailassignment.domain.repository.ProductRepository

class ProductListUseCase(private val repository: ProductRepository) :
    UseCase<RRApiResult<ProductsListUIModel>, String?> {
    override suspend fun execute(params: String?): RRApiResult<ProductsListUIModel> {
        return repository.getProductList()

    }
}