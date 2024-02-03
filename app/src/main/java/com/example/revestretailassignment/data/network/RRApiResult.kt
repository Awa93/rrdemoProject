package com.example.revestretailassignment.data.network

sealed class RRApiResult<T>(val data: T? = null, val message: String = "", val code: Int = -1) {
    class Success<T>(data: T) : RRApiResult<T>(data)
    class Error<T>(message: String, code: Int) : RRApiResult<T>(message = message, code = code)
}

val RRApiResult<*>.isSuccess
    get() = this is RRApiResult.Success && data != null