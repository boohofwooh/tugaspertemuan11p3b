package com.example.pertemuan11p3b.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("name")
    val name: String,
    @SerializedName("hp")
    val hp: String
)
