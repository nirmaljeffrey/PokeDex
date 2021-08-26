package com.nirmaljeffrey.dev.pokedex.initializers

import android.content.Context
import androidx.startup.Initializer
import com.nirmaljeffrey.dev.pokedex.di.DebugInitializerEntryPoint

class DebugDependencyGraphInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        DebugInitializerEntryPoint.resolve(context)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}