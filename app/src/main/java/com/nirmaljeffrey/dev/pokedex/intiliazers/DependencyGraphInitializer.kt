package com.nirmaljeffrey.dev.pokedex.intiliazers

import android.content.Context
import androidx.startup.Initializer
import com.nirmaljeffrey.dev.pokedex.di.InitializerEntryPoint

class DependencyGraphInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        InitializerEntryPoint.resolve(context)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}