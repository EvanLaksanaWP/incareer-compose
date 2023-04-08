package com.raion.incareer.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object Constants{

    const val SPLASH_SCREEN_DURATION = 2000L
    private const val USER_PREFERENCE_NAME = "user_preference"
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name =  USER_PREFERENCE_NAME)

}