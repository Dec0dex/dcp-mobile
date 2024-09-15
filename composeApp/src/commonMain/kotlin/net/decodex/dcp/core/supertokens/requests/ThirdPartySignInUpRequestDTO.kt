import kotlinx.serialization.Serializable
import net.decodex.dcp.core.supertokens.responses.ThirdPartyTokensDTO

@Serializable
data class RedirectUriInfoDTO(
    val redirectURIOnProviderDashboard: String,
    val redirectURIQueryParams: Map<String, String>,
    val pkceCodeVerifier: String?,
)

@Serializable
data class ThirdPartySignInUpRequestDTO(
    val thirdPartyId: String,
    val redirectURIInfo: RedirectUriInfoDTO? = null,
    val oAuthTokens: ThirdPartyTokensDTO? = null,
    val clientType: String? = null,
)
