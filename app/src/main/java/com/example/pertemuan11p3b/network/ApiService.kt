package com.example.pertemuan11p3b.network

import com.example.pertemuan11p3b.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("cards")
    fun getAllUser(): Call<Users>
}