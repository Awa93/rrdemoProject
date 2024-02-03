package com.example.revestretailassignment.domain.model

import com.example.revestretailassignment.application.AppConstant

data class ProductsListUIModel(
    val products: List<Product>,
    val total:Int,
    val skip:Int,
    val limit:Int
)

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>,
)

fun getEmptyProduct():Product{
    return Product(
        id = 0,
        title = AppConstant.EMPTY,
        description = AppConstant.EMPTY,
        price = 0,
        discountPercentage = 0.0,
        rating = 0.0,
        stock = 0,
        brand = AppConstant.EMPTY,
        category = AppConstant.EMPTY,
        thumbnail = AppConstant.EMPTY,
        images = emptyList(),
    )
}
