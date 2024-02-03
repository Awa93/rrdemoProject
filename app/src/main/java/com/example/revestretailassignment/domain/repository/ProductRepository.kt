package com.example.revestretailassignment.domain.repository

import com.example.revestretailassignment.data.network.RRApiResult
import com.example.revestretailassignment.domain.model.Product
import com.example.revestretailassignment.domain.model.ProductsListUIModel

interface ProductRepository {
    suspend fun getProductList(): RRApiResult<ProductsListUIModel>
    suspend fun getProductDetail(productId:String?): RRApiResult<Product>
}