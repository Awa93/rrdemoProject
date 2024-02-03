package com.example.revestretailassignment.di

import com.example.revestretailassignment.di.network.networkDependency
import com.example.revestretailassignment.di.repository.repositoryDependency
import com.example.revestretailassignment.di.usecase.useCaseDependency
import com.example.revestretailassignment.di.viewmodel.viewModelDependency

val appComponent = listOf(
    networkDependency,
    repositoryDependency,
    useCaseDependency,
    viewModelDependency
)