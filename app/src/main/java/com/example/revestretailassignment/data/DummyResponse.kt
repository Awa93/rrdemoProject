package com.example.revestretailassignment.data

import com.example.revestretailassignment.application.AppConstant.EMPTY
import com.example.revestretailassignment.domain.model.Product
import com.example.revestretailassignment.domain.model.ProductsListUIModel

data class ProductsDataModel(
    val products: List<ProductDataModel>?, val total: Int?, val skip: Int?, val limit: Int?
)

data class ProductDataModel(
    val id: Int?,
    val title: String?,
    val description: String?,
    val price: Int?,
    val discountPercentage: Double?,
    val rating: Double?,
    val stock: Int?,
    val brand: String?,
    val category: String?,
    val thumbnail: String?,
    val images: List<String>?,
)

fun ProductsDataModel.toUIModel(): ProductsListUIModel {
    val list = arrayListOf<Product>()
    this.products?.forEach {
        val product = Product(
            id = it.id ?: 0,
            title = it.title ?: EMPTY,
            description = it.description ?: EMPTY,
            price = it.price ?: 0,
            discountPercentage = it.discountPercentage ?: 0.0,
            rating = it.rating ?: 0.0,
            stock = it.stock ?: 0,
            brand = it.brand ?: EMPTY,
            category = it.category ?: EMPTY,
            thumbnail = it.thumbnail ?: EMPTY,
            images = it.images ?: emptyList(),
        )
        list.add(product)
    }

    return ProductsListUIModel(
        products = list, total = this.total ?: 0, skip = this.skip ?: 0, limit = this.limit ?: 0
    )
}

fun ProductDataModel.toUiModel() : Product{
    return Product(
        id = this.id ?: 0,
        title = this.title ?: EMPTY,
        description = this.description ?: EMPTY,
        price = this.price ?: 0,
        discountPercentage = this.discountPercentage ?: 0.0,
        rating = this.rating ?: 0.0,
        stock = this.stock ?: 0,
        brand = this.brand ?: EMPTY,
        category = this.category ?: EMPTY,
        thumbnail = this.thumbnail ?: EMPTY,
        images = this.images ?: emptyList(),
    )

}
