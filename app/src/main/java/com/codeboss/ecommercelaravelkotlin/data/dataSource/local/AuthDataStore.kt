package com.codeboss.ecommercelaravelkotlin.data.dataSource.local

import android.util.Base64
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.codeboss.ecommercelaravelkotlin.core.Config.AUTH_KEY
import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.json.JSONObject
import java.util.Date

class AuthDataStore constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun saveUser(authResponse: AuthResponse) {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref[dataStoreKey] = authResponse.toJson()
        }
    }

    fun getData(): Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { pref ->
            if (pref[dataStoreKey] != null) {
                AuthResponse.fromJson(pref[dataStoreKey]!!)
            }else {
                AuthResponse()
            }
        }
    }

}