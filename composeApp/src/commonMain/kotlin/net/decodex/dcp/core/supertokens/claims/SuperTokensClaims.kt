package net.decodex.dcp.core.supertokens.claims

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.common.SuperTokensClaims
import net.decodex.dcp.core.utils.StringListSerializer

@Serializable
data class ClaimMFA(
    @SerialName(SuperTokensClaims.MFA_FACTORS) val factors: Map<String, Long>,
    @SerialName(SuperTokensClaims.MFA_VERIFIED) val verified: Boolean,
)

@Serializable
data class AccessTokenClaims(
    @SerialName(SuperTokensClaims.EXPIRES_AT) val expiresAt: Long,
    @SerialName(SuperTokensClaims.ISSUED_AT) val issuedAt: Long,
    @SerialName(SuperTokensClaims.USER_ID) val sub: String,
    @SerialName(SuperTokensClaims.ISSUER) val issuer: String,
    @SerialName(SuperTokensClaims.AUDIENCE)
    @Serializable(with = StringListSerializer::class)
    val audience: List<String>? = null,
    @SerialName(SuperTokensClaims.EMAIL) val email: String? = null,
    @SerialName(SuperTokensClaims.EMAIL_VERIFIED) val emailVerified: Boolean? = null,
    @SerialName(SuperTokensClaims.PHONE_NUMBER) val phoneNumber: String? = null,
    @SerialName(SuperTokensClaims.ROLES) val roles: List<String>? = null,
    @SerialName(SuperTokensClaims.PERMISSIONS) val permissions: List<String>? = null,
    @SerialName(SuperTokensClaims.MFA) val multiFactor: ClaimMFA? = null,
)
