//[composeApp](../../index.md)/[net.decodex.dcp.core.supertokens.common](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [SuperTokensClaims](-super-tokens-claims/index.md) | [common]<br>object [SuperTokensClaims](-super-tokens-claims/index.md) |
| [SuperTokensRoutes](-super-tokens-routes/index.md) | [common]<br>object [SuperTokensRoutes](-super-tokens-routes/index.md) |
| [SuperTokensStatus](-super-tokens-status/index.md) | [common]<br>sealed class [SuperTokensStatus](-super-tokens-status/index.md) |
| [SuperTokensStatusException](-super-tokens-status-exception/index.md) | [common]<br>open class [SuperTokensStatusException](-super-tokens-status-exception/index.md)(val status: [SuperTokensStatus](-super-tokens-status/index.md), message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [RuntimeException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-runtime-exception/index.html), [Error](../net.decodex.dcp.core.utils/-error/index.md) |
| [ThirdPartyAuth](-third-party-auth/index.md) | [common]<br>object [ThirdPartyAuth](-third-party-auth/index.md) |

## Properties

| Name | Summary |
|---|---|
| [COOKIE_ACCESS_TOKEN](-c-o-o-k-i-e_-a-c-c-e-s-s_-t-o-k-e-n.md) | [common]<br>const val [COOKIE_ACCESS_TOKEN](-c-o-o-k-i-e_-a-c-c-e-s-s_-t-o-k-e-n.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [COOKIE_REFRESH_TOKEN](-c-o-o-k-i-e_-r-e-f-r-e-s-h_-t-o-k-e-n.md) | [common]<br>const val [COOKIE_REFRESH_TOKEN](-c-o-o-k-i-e_-r-e-f-r-e-s-h_-t-o-k-e-n.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [FORM_FIELD_EMAIL_ID](-f-o-r-m_-f-i-e-l-d_-e-m-a-i-l_-i-d.md) | [common]<br>const val [FORM_FIELD_EMAIL_ID](-f-o-r-m_-f-i-e-l-d_-e-m-a-i-l_-i-d.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [FORM_FIELD_NEW_PASSWORD_ID](-f-o-r-m_-f-i-e-l-d_-n-e-w_-p-a-s-s-w-o-r-d_-i-d.md) | [common]<br>const val [FORM_FIELD_NEW_PASSWORD_ID](-f-o-r-m_-f-i-e-l-d_-n-e-w_-p-a-s-s-w-o-r-d_-i-d.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [FORM_FIELD_PASSWORD_ID](-f-o-r-m_-f-i-e-l-d_-p-a-s-s-w-o-r-d_-i-d.md) | [common]<br>const val [FORM_FIELD_PASSWORD_ID](-f-o-r-m_-f-i-e-l-d_-p-a-s-s-w-o-r-d_-i-d.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [HEADER_ACCESS_TOKEN](-h-e-a-d-e-r_-a-c-c-e-s-s_-t-o-k-e-n.md) | [common]<br>const val [HEADER_ACCESS_TOKEN](-h-e-a-d-e-r_-a-c-c-e-s-s_-t-o-k-e-n.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [HEADER_ANTI_CSRF](-h-e-a-d-e-r_-a-n-t-i_-c-s-r-f.md) | [common]<br>const val [HEADER_ANTI_CSRF](-h-e-a-d-e-r_-a-n-t-i_-c-s-r-f.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [HEADER_RECIPE_ID](-h-e-a-d-e-r_-r-e-c-i-p-e_-i-d.md) | [common]<br>const val [HEADER_RECIPE_ID](-h-e-a-d-e-r_-r-e-c-i-p-e_-i-d.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [HEADER_REFRESH_TOKEN](-h-e-a-d-e-r_-r-e-f-r-e-s-h_-t-o-k-e-n.md) | [common]<br>const val [HEADER_REFRESH_TOKEN](-h-e-a-d-e-r_-r-e-f-r-e-s-h_-t-o-k-e-n.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RECIPE_ACCOUNT_LINKING](-r-e-c-i-p-e_-a-c-c-o-u-n-t_-l-i-n-k-i-n-g.md) | [common]<br>const val [RECIPE_ACCOUNT_LINKING](-r-e-c-i-p-e_-a-c-c-o-u-n-t_-l-i-n-k-i-n-g.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RECIPE_EMAIL_PASSWORD](-r-e-c-i-p-e_-e-m-a-i-l_-p-a-s-s-w-o-r-d.md) | [common]<br>const val [RECIPE_EMAIL_PASSWORD](-r-e-c-i-p-e_-e-m-a-i-l_-p-a-s-s-w-o-r-d.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RECIPE_EMAIL_VERIFICATION](-r-e-c-i-p-e_-e-m-a-i-l_-v-e-r-i-f-i-c-a-t-i-o-n.md) | [common]<br>const val [RECIPE_EMAIL_VERIFICATION](-r-e-c-i-p-e_-e-m-a-i-l_-v-e-r-i-f-i-c-a-t-i-o-n.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RECIPE_META_DATA](-r-e-c-i-p-e_-m-e-t-a_-d-a-t-a.md) | [common]<br>const val [RECIPE_META_DATA](-r-e-c-i-p-e_-m-e-t-a_-d-a-t-a.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RECIPE_MULTI_FACTOR_AUTH](-r-e-c-i-p-e_-m-u-l-t-i_-f-a-c-t-o-r_-a-u-t-h.md) | [common]<br>const val [RECIPE_MULTI_FACTOR_AUTH](-r-e-c-i-p-e_-m-u-l-t-i_-f-a-c-t-o-r_-a-u-t-h.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RECIPE_PASSWORDLESS](-r-e-c-i-p-e_-p-a-s-s-w-o-r-d-l-e-s-s.md) | [common]<br>const val [RECIPE_PASSWORDLESS](-r-e-c-i-p-e_-p-a-s-s-w-o-r-d-l-e-s-s.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RECIPE_ROLES](-r-e-c-i-p-e_-r-o-l-e-s.md) | [common]<br>const val [RECIPE_ROLES](-r-e-c-i-p-e_-r-o-l-e-s.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RECIPE_SESSION](-r-e-c-i-p-e_-s-e-s-s-i-o-n.md) | [common]<br>const val [RECIPE_SESSION](-r-e-c-i-p-e_-s-e-s-s-i-o-n.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RECIPE_THIRD_PARTY](-r-e-c-i-p-e_-t-h-i-r-d_-p-a-r-t-y.md) | [common]<br>const val [RECIPE_THIRD_PARTY](-r-e-c-i-p-e_-t-h-i-r-d_-p-a-r-t-y.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RECIPE_TOTP](-r-e-c-i-p-e_-t-o-t-p.md) | [common]<br>const val [RECIPE_TOTP](-r-e-c-i-p-e_-t-o-t-p.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [toStatus](to-status.md) | [common]<br>fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[toStatus](to-status.md)(): [SuperTokensStatus](-super-tokens-status/index.md) |
