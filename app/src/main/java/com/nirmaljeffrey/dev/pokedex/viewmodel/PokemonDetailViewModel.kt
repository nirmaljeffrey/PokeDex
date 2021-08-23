package com.nirmaljeffrey.dev.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import com.nirmaljeffrey.dev.pokedex.data.remote.responses.Pokemon
import com.nirmaljeffrey.dev.pokedex.repository.PokemonRepository
import com.nirmaljeffrey.dev.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return pokemonRepository.getPokemonInfo(pokemonName);
    }
}