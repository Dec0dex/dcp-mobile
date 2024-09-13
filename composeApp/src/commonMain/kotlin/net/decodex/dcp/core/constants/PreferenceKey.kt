package net.decodex.dcp.core.constants

import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKey {
    val accessToken = stringPreferencesKey("accessToken")
    val refreshToken = stringPreferencesKey("refreshToken")
}
