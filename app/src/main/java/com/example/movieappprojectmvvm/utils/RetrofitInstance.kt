package com.example.movieappprojectmvvm.utils

import com.example.movieappprojectmvvm.domain.ApiInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    val api: ApiInterface by lazy {
        try {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

            Retrofit.Builder()
                .baseUrl(Util.BASE)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        } catch (e: Exception) {
            throw RuntimeException("Failed to initialize Retrofit: ${e.message}", e)
        }
    }
}


