package com.example.revestretailassignment.data.repository

import com.example.revestretailassignment.data.network.RRApiResult
import com.example.revestretailassignment.data.network.RRApiService
import com.example.revestretailassignment.data.toUIModel
import com.example.revestretailassignment.data.toUiModel
import com.example.revestretailassignment.domain.model.Product
import com.example.revestretailassignment.domain.model.ProductsListUIModel
import com.example.revestretailassignment.domain.repository.ProductRepository

class ProductRepositoryImpl(private val rrApiService: RRApiService) : ProductRepository {
    override suspend fun getProductList(): RRApiResult<ProductsListUIModel> {
        val response = rrApiService.getAllProducts()
        return if (response.isSuccessful) {
            val products = response.body()?.toUIModel()

            products?.let {
                RRApiResult.Success(it)
            } ?: RRApiResult.Error("Unknown Error", 200)
        } else {
            RRApiResult.Error(response.message(), response.code())
        }
    }

    override suspend fun getProductDetail(productId: String?): RRApiResult<Product> {
        val response = rrApiService.getProductDetails(productId)
        return if (response.isSuccessful) {
            val products = response.body()?.toUiModel()

            products?.let {
                RRApiResult.Success(it)
            } ?: RRApiResult.Error("Unknown Error", 200)
        } else {
            RRApiResult.Error(response.message(), response.code())
        }
    }

}