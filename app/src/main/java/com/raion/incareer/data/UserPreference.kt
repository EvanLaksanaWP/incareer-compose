package com.raion.incareer.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.raion.incareer.util.Constants.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserPreference(context: Context) {

    private val dataStore = context.dataStore

    suspend fun saveOnBoardingState(isCompleted: Boolean){
        dataStore.edit {preferences ->
            preferences[PreferencesKey.onBoardingkey] = isCompleted
        }
    }

    fun readOnBoardingState(): Flow <Boolean> {
        return dataStore.data
            .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            val onBoardingState = preferences[PreferencesKey.onBoardingkey] ?: false
            onBoardingState
        }
    }

    suspend fun saveUid(uid: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.uidKey] = uid
        }
    }

    val readUid: Flow<String?>
        get() = dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[PreferencesKey.uidKey]
            }

    private object PreferencesKey{
        val onBoardingkey = booleanPreferencesKey(name = "on_boarding_completed")
        val uidKey = stringPreferencesKey(name = "uid")
    }
}