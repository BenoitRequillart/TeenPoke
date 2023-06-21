package com.example.teenpoke.usecases

import com.example.teenpoke.models.PokemonModel
import com.example.teenpoke.repositories.PokedexRepository
import com.google.gson.Gson

class GetAllPkmUseCase() {
    private val pokedexRepository: PokedexRepository = PokedexRepository()
    suspend fun execute() =  pokedexRepository.getAllPkm()
}