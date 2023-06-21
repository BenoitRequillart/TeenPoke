package com.example.teenpoke.repositories

import com.example.teenpoke.models.PokemonModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokemonApiService{
    @GET("pokemon")
    suspend fun getAllPkm(): List<PokemonModel>
}

object APIServiceBuilder {
    private const val BASE_URL = "https://api-pokemon-fr.vercel.app/api/v1/"

    var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService: PokemonApiService = retrofit.create(PokemonApiService::class.java)
}