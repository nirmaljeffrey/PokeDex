package com.nirmaljeffrey.dev.pokedex.di

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber


class ReleaseTree constructor(private val firebaseCrashlytics: FirebaseCrashlytics) :
    Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (isLoggable(tag, priority)) {
            if (priority == Log.ERROR) {
                t?.let { firebaseCrashlytics.recordException(it) }
            } else {
                firebaseCrashlytics.log(message)
            }
        }
    }

    override fun isLoggable(tag: String?, priority: Int): Boolean {
        return priority == Log.WARN || priority == Log.ERROR
    }
}