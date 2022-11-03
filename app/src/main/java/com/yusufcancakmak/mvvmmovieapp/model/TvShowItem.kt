package com.yusufcancakmak.mvvmmovieapp.model

import com.google.gson.annotations.SerializedName


data class TvShowItem(

    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: İmage,
    @SerializedName("name")
    val name: String

)