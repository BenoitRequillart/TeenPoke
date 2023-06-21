package com.example.teenpoke.viewmodels

import com.example.teenpoke.models.PokemonModel
import com.example.teenpoke.usecases.GetAllPkmUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel {
    private val _uiState = MutableStateFlow(HomeUiState())
    private val loginUseCase: GetAllPkmUseCase = GetAllPkmUseCase()
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    fun getAllPkm(){
        val useCase: GetAllPkmUseCase = GetAllPkmUseCase()
        CoroutineScope(Dispatchers.IO).launch {
            val result = useCase.execute()
            if(result != null){
                withContext( Dispatchers.Main){
                    _uiState.value = HomeUiState(result)
                }
            }


        }
    }
}

data class HomeUiState(val test: List<PokemonModel> = emptyList())