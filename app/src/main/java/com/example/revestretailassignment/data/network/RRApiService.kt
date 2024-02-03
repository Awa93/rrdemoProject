package com.example.revestretailassignment.data.network

import com.example.revestretailassignment.data.ProductDataModel
import com.example.revestretailassignment.data.ProductsDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RRApiService {
    @GET("products")
    suspend fun getAllProducts() : Response<ProductsDataModel>

    @GET("products/{id}")
    suspend fun getProductDetails(
        @Path("id") id: String?
    ) : Response<ProductDataModel>
}