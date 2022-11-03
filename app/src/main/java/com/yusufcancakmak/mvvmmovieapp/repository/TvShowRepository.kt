package com.yusufcancakmak.mvvmmovieapp.repository

import com.yusufcancakmak.mvvmmovieapp.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject constructor(private val api:ApiService){

    suspend fun getTvShows()=api.getTvShows()
}