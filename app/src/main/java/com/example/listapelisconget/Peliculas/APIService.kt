package com.example.listapelisconget.Peliculas

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getPelisMovies(@Url url:String): Response<PelisResponser>
}