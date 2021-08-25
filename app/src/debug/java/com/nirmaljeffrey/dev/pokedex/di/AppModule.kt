package com.nirmaljeffrey.dev.pokedex.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDebugModule {

    @Provides
    @Singleton
    @IntoSet
    fun providesHttpLoggingInterceptor(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return loggingInterceptor
    }

    @Provides
    @Singleton
    @IntoSet
    fun providesStethoInterceptor(): Interceptor {
        return StethoInterceptor()
    }

    @Provides
    @Singleton
    @IntoSet
    fun providesChuckerInterceptor(@ApplicationContext context: Context): Interceptor {
        return ChuckerInterceptor.Builder(context).build()
    }
}