package com.nirmaljeffrey.dev.pokedex.di

import android.content.Context
import com.facebook.stetho.Stetho
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StethoService @Inject constructor(@ApplicationContext private val context: Context) {
    fun initialize() {
        Stetho.initializeWithDefaults(context)
    }
}