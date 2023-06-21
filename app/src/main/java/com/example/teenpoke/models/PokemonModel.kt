package com.example.teenpoke.models

data class PokemonModel(val id: Int, val name: NameModel, val sprites: ImageModel, val type: List<TypeModel>)