package com.example.revestretailassignment.di.usecase

import com.example.revestretailassignment.domain.usecase.ProductDetailsUseCase
import com.example.revestretailassignment.domain.usecase.ProductListUseCase
import org.koin.dsl.module

val useCaseDependency = module {
    single { ProductListUseCase(get()) }
    single { ProductDetailsUseCase(get()) }
}