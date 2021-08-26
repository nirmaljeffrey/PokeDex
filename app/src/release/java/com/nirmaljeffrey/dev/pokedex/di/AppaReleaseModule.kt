package com.nirmaljeffrey.dev.pokedex.di

import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppReleaseModule {
    @Provides
    @Singleton
    fun providesReleaseTimberTree(firebaseCrashlytics: FirebaseCrashlytics): Timber.Tree {
        return ReleaseTree(firebaseCrashlytics)
    }
}