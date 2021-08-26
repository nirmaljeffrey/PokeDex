package com.nirmaljeffrey.dev.pokedex.di

import android.content.Context
import com.nirmaljeffrey.dev.pokedex.initializers.StethoInitializer
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface DebugInitializerEntryPoint {
    companion object {
        fun resolve(context: Context): DebugInitializerEntryPoint {
            val appContext = context.applicationContext ?: throw IllegalStateException()
            return EntryPointAccessors.fromApplication(
                appContext,
                DebugInitializerEntryPoint::class.java
            )
        }
    }

    fun inject(stethoInitializer: StethoInitializer)
}