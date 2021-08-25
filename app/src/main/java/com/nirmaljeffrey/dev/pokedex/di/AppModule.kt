package com.nirmaljeffrey.dev.pokedex.di

import com.nirmaljeffrey.dev.pokedex.data.remote.PokeApi
import com.nirmaljeffrey.dev.pokedex.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.Multibinds
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Multibinds
    abstract fun providesNetworkInterceptor(): Set<@JvmSuppressWildcards Interceptor>

    companion object {
        @Provides
        @Singleton
        fun providesOkHttpClient(networkInterceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient {
            val builder: OkHttpClient.Builder = OkHttpClient.Builder();
            if (!networkInterceptors.isEmpty()) {
                builder.networkInterceptors().addAll(networkInterceptors)
            }
            return builder
                .build()
        }

        @Provides
        @Singleton
        fun providesPokeApi(okHttpClient: OkHttpClient): PokeApi {
            return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
                .create(PokeApi::class.java)
        }
    }
}