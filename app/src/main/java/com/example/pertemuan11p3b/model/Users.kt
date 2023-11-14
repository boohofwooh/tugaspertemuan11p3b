package com.example.pertemuan11p3b.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("data")
    val data: List<Data>
)
