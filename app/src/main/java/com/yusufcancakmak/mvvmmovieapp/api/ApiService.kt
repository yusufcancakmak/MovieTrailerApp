package com.yusufcancakmak.mvvmmovieapp.api

import com.yusufcancakmak.mvvmmovieapp.helper.Constants
import com.yusufcancakmak.mvvmmovieapp.model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POİNT)
    suspend fun getTvShows():Response<TvShowResponse>
}