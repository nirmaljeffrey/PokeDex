package com.nirmaljeffrey.dev.pokedex.repository

import com.nirmaljeffrey.dev.pokedex.data.remote.PokeApi
import com.nirmaljeffrey.dev.pokedex.data.remote.responses.Pokemon
import com.nirmaljeffrey.dev.pokedex.data.remote.responses.PokemonList
import com.nirmaljeffrey.dev.pokedex.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class  PokemonRepository @Inject constructor(
    private val pokeApi : PokeApi
) {


    suspend fun getPokemonList(limit : Int, offset : Int) : Resource<PokemonList> {
        val response = try {
            pokeApi.getPokemonList(offset, limit)
        } catch (exception : Exception) {
            return Resource.Error("Something went wrong", null)
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName : String) : Resource<Pokemon> {
        val response = try {
            pokeApi.getPokemonInfo(pokemonName)
        } catch (exception : Exception) {
            return Resource.Error("Something went wrong", null)
        }
        return Resource.Success(response)
    }
}