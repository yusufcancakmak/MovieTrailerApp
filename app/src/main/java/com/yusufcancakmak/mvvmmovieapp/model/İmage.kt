package com.yusufcancakmak.mvvmmovieapp.model

import com.google.gson.annotations.SerializedName


data class İmage(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("original")
    val original: String
)