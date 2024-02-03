package com.example.revestretailassignment.domain

interface UseCase<T, Params> {
    suspend fun execute(params: Params): T
}