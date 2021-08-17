package com.nirmaljeffrey.dev.pokedex.di

import com.google.gson.Gson
import com.nirmaljeffrey.dev.pokedex.data.remote.PokeApi
import com.nirmaljeffrey.dev.pokedex.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule

@Provides
@Singleton
fun providesPokeApi() : PokeApi {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()
        .create(PokeApi::class.java)
}