package com.example.revestretailassignment.data.network

import com.example.revestretailassignment.data.model.ProductDataModel
import com.example.revestretailassignment.data.model.ProductsDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RRApiService {
    @GET(ApiEndPoints.PRODUCTS)
    suspend fun getAllProducts() : Response<ProductsDataModel>

    @GET("${ApiEndPoints.PRODUCTS}/{id}")
    suspend fun getProductDetails(
        @Path("id") id: String?
    ) : Response<ProductDataModel>
}