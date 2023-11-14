package com.example.pertemuan11p3b.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun getInstance(): ApiService {
        val mOkHttpInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val mOkHttpClient = OkHttpClient.Builder().addInterceptor(mOkHttpInterceptor).build()
        val builder = Retrofit.Builder()
            .baseUrl("https://api.pokemontcg.io/v2/")
            .client(mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
        return builder.create(ApiService::class.java)
    }
}