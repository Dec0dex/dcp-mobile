package net.decodex.dcp.core.supertokens.recipes.core.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.decodex.dcp.core.supertokens.models.SuperTokensUser

interface SuperTokensUserRepository {
    val superTokensUser: StateFlow<SuperTokensUser?>

    suspend fun updateUser(user: SuperTokensUser?)

    suspend fun getUser(): SuperTokensUser?
}

@OptIn(ExperimentalSerializationApi::class)
class SuperTokensUserRepositoryImpl(
    private val settings: DataStore<Preferences>,
    private val json: Json =
        Json {
            isLenient = true
            explicitNulls = false
            encodeDefaults = true
            ignoreUnknownKeys = true
        },
    scope: CoroutineScope,
) : SuperTokensUserRepository {
    override val superTokensUser: MutableStateFlow<SuperTokensUser?> = MutableStateFlow(null)

    init {
        scope.launch {
            superTokensUser.value = getUser()
        }
    }

    override suspend fun updateUser(user: SuperTokensUser?) {
        this.superTokensUser.value = user
        if (user != null) {
            settings.edit {
                it[KEY_SuperTokensUser] = json.encodeToString(SuperTokensUser)
            }
        } else {
            settings.edit {
                it.remove(KEY_SuperTokensUser)
            }
        }
    }

    override suspend fun getUser(): SuperTokensUser? =
        settings.data.map {
            val user = it[KEY_SuperTokensUser]
            user?.let {
                json.decodeFromString<SuperTokensUser>(user)
            }
        }.firstOrNull()

    companion object {
        private val KEY_SuperTokensUser = stringPreferencesKey("SuperTokensUser")
    }
}
