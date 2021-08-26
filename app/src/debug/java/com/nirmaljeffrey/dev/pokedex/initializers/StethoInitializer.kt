package com.nirmaljeffrey.dev.pokedex.initializers

import android.content.Context
import androidx.startup.Initializer
import com.nirmaljeffrey.dev.pokedex.di.DebugInitializerEntryPoint
import com.nirmaljeffrey.dev.pokedex.di.StethoService
import javax.inject.Inject

class StethoInitializer : Initializer<StethoService> {
    @Inject
    lateinit var stethoService: StethoService
    override fun create(context: Context): StethoService {
        DebugInitializerEntryPoint.resolve(context).inject(this)
        stethoService.initialize()
        return stethoService
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf(DebugDependencyGraphInitializer::class.java)
    }
}