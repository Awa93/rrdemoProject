package com.example.revestretailassignment.di.repository

import com.example.revestretailassignment.data.repository.ProductRepositoryImpl
import com.example.revestretailassignment.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryDependency = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
}