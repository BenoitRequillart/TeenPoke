package com.example.teenpoke.repositories

import com.example.teenpoke.models.PokemonModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject
import java.net.URL

class PokedexRepository {
    suspend fun getAllPkm(): List<PokemonModel>? {
        val url: String = "https://api-pokemon-fr.vercel.app/api/v1/pokemon"
        return try {
            APIServiceBuilder.apiService.getAllPkm()
        } catch (e: Exception) {
            e.printStackTrace()
            println(e)
            null
        }
    }
}