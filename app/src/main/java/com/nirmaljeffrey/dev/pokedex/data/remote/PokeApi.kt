package com.nirmaljeffrey.dev.pokedex.data.remote

import com.nirmaljeffrey.dev.pokedex.data.remote.responses.Pokemon
import com.nirmaljeffrey.dev.pokedex.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset : Int,
        @Query("limit") limit : Int
    ): PokemonList

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonInfo(
        @Path("pokemonName") pokemonName : String
    ) : Pokemon
}