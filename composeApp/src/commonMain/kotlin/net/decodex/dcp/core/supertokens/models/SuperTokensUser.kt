package net.decodex.dcp.core.supertokens.models

import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.RECIPE_EMAIL_PASSWORD
import net.decodex.dcp.core.supertokens.common.RECIPE_PASSWORDLESS
import net.decodex.dcp.core.supertokens.common.RECIPE_THIRD_PARTY

@Serializable
data class ThirdParty(
    val id: String,
    val userId: String,
)

@Serializable
data class LoginMethod(
    val tenantIds: List<String>? = null,
    val recipeUserId: String,
    val verified: Boolean,
    val timeJoined: Long,
    val recipeId: String,
    val email: String? = null,
    val phoneNumber: String? = null,
    val thirdParty: ThirdParty? = null,
)

@Serializable
data class SuperTokensUser(
    val id: String,
    val isPrimaryUser: Boolean? = null,
    val tenantIds: List<String>? = null,
    val emails: List<String>? = null,
    val phoneNumbers: List<String>? = null,
    val timeJoined: Long,
    val thirdParty: List<ThirdParty>? = null,
    val loginMethods: List<LoginMethod>? = null,
    val recipeUserId: String? = null,
) {
    @Deprecated("Use emails list instead", ReplaceWith("emails?.firstOrNull()"))
    val email: String?
        get() = emails?.firstOrNull()

    @Deprecated("Use phoneNumbers list instead", ReplaceWith("phoneNumbers?.firstOrNull()"))
    val phoneNumber: String?
        get() = phoneNumbers?.firstOrNull()
}

val SuperTokensUser.isEmailPassword: Boolean
    get() = loginMethods?.any { it.recipeId == RECIPE_EMAIL_PASSWORD } ?: false

val SuperTokensUser.isThirdParty: Boolean
    get() = loginMethods?.any { it.recipeId == RECIPE_THIRD_PARTY } ?: false

val SuperTokensUser.isPasswordless: Boolean
    get() = loginMethods?.any { it.recipeId == RECIPE_PASSWORDLESS } ?: false
