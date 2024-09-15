package net.decodex.dcp.core.supertokens.recipes.session.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map

class TokensRepositorySettings(
    private val settings: DataStore<Preferences>,
) : TokensRepository() {
    // AccessToken is always in memory, because it is short lived anyway and will need to be refreshed
    // on app start.
    private var accessToken: String? = null

    override suspend fun getAccessToken() = accessToken

    override suspend fun setAccessToken(accessToken: String?) {
        this.accessToken = accessToken
    }

    override suspend fun getRefreshToken(): String? {
        return settings.data.map { it[KEY_REFRESH_TOKEN] }.last()
    }

    override suspend fun setRefreshToken(refreshToken: String?) {
        settings.edit { edit ->
            refreshToken?.also { edit[KEY_REFRESH_TOKEN] = it }
        }
    }

    companion object {
        private val KEY_REFRESH_TOKEN = stringPreferencesKey("sRefreshToken")
    }
}
