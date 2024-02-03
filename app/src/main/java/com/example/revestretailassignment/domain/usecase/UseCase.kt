package com.example.revestretailassignment.domain.usecase

interface UseCase<T, Params> {
    suspend fun execute(params: Params): T
}