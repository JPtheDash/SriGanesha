package com.example.makeyourganesha.core.data

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class CreationSelection(
    val head: String? = null,
    val body: String? = null,
    val vahana: String? = null,
    val stage: String? = null,
    val background: String? = null,
    val artifacts: String? = null
)

class SelectionStore(private val context: Context) {
    private val Context.dataStore by preferencesDataStore(name = "selections")

    private object Keys {
        val HEAD = stringPreferencesKey("head")
        val BODY = stringPreferencesKey("body")
        val VAHANA = stringPreferencesKey("vahana")
        val STAGE = stringPreferencesKey("stage")
        val BACKGROUND = stringPreferencesKey("background")
        val ARTIFACTS = stringPreferencesKey("artifacts")
    }

    val flow: Flow<CreationSelection> = context.dataStore.data.map { prefs ->
        CreationSelection(
            head = prefs[Keys.HEAD],
            body = prefs[Keys.BODY],
            vahana = prefs[Keys.VAHANA],
            stage = prefs[Keys.STAGE],
            background = prefs[Keys.BACKGROUND],
            artifacts = prefs[Keys.ARTIFACTS]
        )
    }

    suspend fun update(update: CreationSelection) {
        context.dataStore.edit { prefs: Preferences ->
            update.head?.let { prefs[Keys.HEAD] = it }
            update.body?.let { prefs[Keys.BODY] = it }
            update.vahana?.let { prefs[Keys.VAHANA] = it }
            update.stage?.let { prefs[Keys.STAGE] = it }
            update.background?.let { prefs[Keys.BACKGROUND] = it }
            update.artifacts?.let { prefs[Keys.ARTIFACTS] = it }
        }
    }
}

