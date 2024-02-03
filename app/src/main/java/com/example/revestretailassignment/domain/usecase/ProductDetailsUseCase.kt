package com.example.revestretailassignment.domain.usecase

import com.example.revestretailassignment.data.network.RRApiResult
import com.example.revestretailassignment.domain.UseCase
import com.example.revestretailassignment.domain.model.Product
import com.example.revestretailassignment.domain.model.ProductsListUIModel
import com.example.revestretailassignment.domain.repository.ProductRepository

class ProductDetailsUseCase(private val repository: ProductRepository) :
    UseCase<RRApiResult<Product>, String?> {
    override suspend fun execute(params: String?): RRApiResult<Product> {
        return repository.getProductDetail(params)

    }
}