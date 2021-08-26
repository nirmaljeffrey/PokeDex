package com.nirmaljeffrey.dev.pokedex.di

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimberService @Inject constructor(private val tree: Timber.Tree) {
    fun initialize() {
        Timber.plant(tree)
    }
}