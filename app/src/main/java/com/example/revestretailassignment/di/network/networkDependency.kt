package com.example.revestretailassignment.di.network

import com.example.revestretailassignment.application.config.AppConfig
import com.example.revestretailassignment.data.network.RRApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkDependency = module {

    single {
        Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named("restClient")))
            .build()
            .create(RRApiService::class.java)
    }

    single(named("restClient")) {
        val builder = OkHttpClient.Builder()
            .writeTimeout(30L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .addInterceptor(CustomInterceptor())

        builder.build()
    }
}

class  CustomInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        return chain.proceed(originalRequest)
    }

}