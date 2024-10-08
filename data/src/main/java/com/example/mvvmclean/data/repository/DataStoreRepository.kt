package com.example.mvvmclean.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.mvvmclean.data.common.constants.Constants
import com.example.mvvmclean.data.common.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import okio.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreRepository @Inject constructor(@ApplicationContext private val context: Context) {

    private object PreferenceKey {
        // save local data
        val isFirstTimeUse = booleanPreferencesKey(Constants.ENDPOINT_SIGNUP)
        //val jwtToken = preferencesKey<String>(Constants.PREFRENCE_TOKEN)
    }

    // save back online
    suspend fun saveIsFistTimeAppUse(isFirstTimeUse: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKey.isFirstTimeUse] = isFirstTimeUse
        }
    }

    val getIsFirstTimeAppUse: Flow<Boolean> =  context.dataStore.data.catch { exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { prefrence ->
        prefrence[PreferenceKey.isFirstTimeUse] ?: false
    }

//    // save back online
//    suspend fun saveIsEnglish(isEnglish: String) {
//        context.dataStore.edit { preferences ->
//            preferences[PreferenceKey.isEnglish] = isEnglish
//        }
//    }

}
