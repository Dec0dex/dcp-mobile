//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.common](../index.md)/[SuperTokensStatus](index.md)

# SuperTokensStatus

sealed class [SuperTokensStatus](index.md)

#### Inheritors

| |
|---|
| [OK](-o-k/index.md) |
| [EMailAlreadyExistsError](-e-mail-already-exists-error/index.md) |
| [WrongCredentialsError](-wrong-credentials-error/index.md) |
| [UnknownUserIdError](-unknown-user-id-error/index.md) |
| [UnknownEMailError](-unknown-e-mail-error/index.md) |
| [UnknownPhoneNumberError](-unknown-phone-number-error/index.md) |
| [ResetPasswordInvalidTokenError](-reset-password-invalid-token-error/index.md) |
| [PasswordPolicyViolatedError](-password-policy-violated-error/index.md) |
| [NotFoundError](-not-found-error/index.md) |
| [InvalidApiKeyError](-invalid-api-key-error/index.md) |
| [UnauthorizedError](-unauthorized-error/index.md) |
| [TryRefreshTokenError](-try-refresh-token-error/index.md) |
| [FormFieldError](-form-field-error/index.md) |
| [EmailAlreadyVerifiedError](-email-already-verified-error/index.md) |
| [EmailVerificationInvalidTokenError](-email-verification-invalid-token-error/index.md) |
| [PasswordlessRestartFlowError](-passwordless-restart-flow-error/index.md) |
| [PasswordlessCodeAlreadyUsedError](-passwordless-code-already-used-error/index.md) |
| [PasswordlessIncorrectCodeError](-passwordless-incorrect-code-error/index.md) |
| [PasswordlessExpiredCodeError](-passwordless-expired-code-error/index.md) |
| [TotpDeviceAlreadyExistsError](-totp-device-already-exists-error/index.md) |
| [TotpNotEnabledError](-totp-not-enabled-error/index.md) |
| [TotpDeviceUnknownError](-totp-device-unknown-error/index.md) |
| [InvalidTotpCodeError](-invalid-totp-code-error/index.md) |
| [TotpLimitReachedError](-totp-limit-reached-error/index.md) |
| [AccountInfoAlreadyAssociatedError](-account-info-already-associated-error/index.md) |
| [RecipeUserIdAlreadyLinkedWithAnotherPrimaryUserError](-recipe-user-id-already-linked-with-another-primary-user-error/index.md) |
| [RecipeUserIdAlreadyLinkedError](-recipe-user-id-already-linked-error/index.md) |
| [NotPrimaryUserError](-not-primary-user-error/index.md) |
| [UnknownRole](-unknown-role/index.md) |
| [AppIdOrTenantIdNotFoundError](-app-id-or-tenant-id-not-found-error/index.md) |
| [UnknownError](-unknown-error/index.md) |

## Types

| Name | Summary |
|---|---|
| [AccountInfoAlreadyAssociatedError](-account-info-already-associated-error/index.md) | [common]<br>data object [AccountInfoAlreadyAssociatedError](-account-info-already-associated-error/index.md) : [SuperTokensStatus](index.md) |
| [AppIdOrTenantIdNotFoundError](-app-id-or-tenant-id-not-found-error/index.md) | [common]<br>class [AppIdOrTenantIdNotFoundError](-app-id-or-tenant-id-not-found-error/index.md)(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [SuperTokensStatus](index.md) |
| [EMailAlreadyExistsError](-e-mail-already-exists-error/index.md) | [common]<br>data object [EMailAlreadyExistsError](-e-mail-already-exists-error/index.md) : [SuperTokensStatus](index.md) |
| [EmailAlreadyVerifiedError](-email-already-verified-error/index.md) | [common]<br>data object [EmailAlreadyVerifiedError](-email-already-verified-error/index.md) : [SuperTokensStatus](index.md) |
| [EmailVerificationInvalidTokenError](-email-verification-invalid-token-error/index.md) | [common]<br>data object [EmailVerificationInvalidTokenError](-email-verification-invalid-token-error/index.md) : [SuperTokensStatus](index.md) |
| [FormFieldError](-form-field-error/index.md) | [common]<br>data object [FormFieldError](-form-field-error/index.md) : [SuperTokensStatus](index.md) |
| [InvalidApiKeyError](-invalid-api-key-error/index.md) | [common]<br>data object [InvalidApiKeyError](-invalid-api-key-error/index.md) : [SuperTokensStatus](index.md) |
| [InvalidTotpCodeError](-invalid-totp-code-error/index.md) | [common]<br>data object [InvalidTotpCodeError](-invalid-totp-code-error/index.md) : [SuperTokensStatus](index.md) |
| [NotFoundError](-not-found-error/index.md) | [common]<br>data object [NotFoundError](-not-found-error/index.md) : [SuperTokensStatus](index.md) |
| [NotPrimaryUserError](-not-primary-user-error/index.md) | [common]<br>data object [NotPrimaryUserError](-not-primary-user-error/index.md) : [SuperTokensStatus](index.md) |
| [OK](-o-k/index.md) | [common]<br>data object [OK](-o-k/index.md) : [SuperTokensStatus](index.md) |
| [PasswordlessCodeAlreadyUsedError](-passwordless-code-already-used-error/index.md) | [common]<br>data object [PasswordlessCodeAlreadyUsedError](-passwordless-code-already-used-error/index.md) : [SuperTokensStatus](index.md) |
| [PasswordlessExpiredCodeError](-passwordless-expired-code-error/index.md) | [common]<br>data object [PasswordlessExpiredCodeError](-passwordless-expired-code-error/index.md) : [SuperTokensStatus](index.md) |
| [PasswordlessIncorrectCodeError](-passwordless-incorrect-code-error/index.md) | [common]<br>data object [PasswordlessIncorrectCodeError](-passwordless-incorrect-code-error/index.md) : [SuperTokensStatus](index.md) |
| [PasswordlessRestartFlowError](-passwordless-restart-flow-error/index.md) | [common]<br>data object [PasswordlessRestartFlowError](-passwordless-restart-flow-error/index.md) : [SuperTokensStatus](index.md) |
| [PasswordPolicyViolatedError](-password-policy-violated-error/index.md) | [common]<br>data object [PasswordPolicyViolatedError](-password-policy-violated-error/index.md) : [SuperTokensStatus](index.md) |
| [RecipeUserIdAlreadyLinkedError](-recipe-user-id-already-linked-error/index.md) | [common]<br>data object [RecipeUserIdAlreadyLinkedError](-recipe-user-id-already-linked-error/index.md) : [SuperTokensStatus](index.md) |
| [RecipeUserIdAlreadyLinkedWithAnotherPrimaryUserError](-recipe-user-id-already-linked-with-another-primary-user-error/index.md) | [common]<br>data object [RecipeUserIdAlreadyLinkedWithAnotherPrimaryUserError](-recipe-user-id-already-linked-with-another-primary-user-error/index.md) : [SuperTokensStatus](index.md) |
| [ResetPasswordInvalidTokenError](-reset-password-invalid-token-error/index.md) | [common]<br>data object [ResetPasswordInvalidTokenError](-reset-password-invalid-token-error/index.md) : [SuperTokensStatus](index.md) |
| [TotpDeviceAlreadyExistsError](-totp-device-already-exists-error/index.md) | [common]<br>data object [TotpDeviceAlreadyExistsError](-totp-device-already-exists-error/index.md) : [SuperTokensStatus](index.md) |
| [TotpDeviceUnknownError](-totp-device-unknown-error/index.md) | [common]<br>data object [TotpDeviceUnknownError](-totp-device-unknown-error/index.md) : [SuperTokensStatus](index.md) |
| [TotpLimitReachedError](-totp-limit-reached-error/index.md) | [common]<br>data object [TotpLimitReachedError](-totp-limit-reached-error/index.md) : [SuperTokensStatus](index.md) |
| [TotpNotEnabledError](-totp-not-enabled-error/index.md) | [common]<br>data object [TotpNotEnabledError](-totp-not-enabled-error/index.md) : [SuperTokensStatus](index.md) |
| [TryRefreshTokenError](-try-refresh-token-error/index.md) | [common]<br>data object [TryRefreshTokenError](-try-refresh-token-error/index.md) : [SuperTokensStatus](index.md) |
| [UnauthorizedError](-unauthorized-error/index.md) | [common]<br>data object [UnauthorizedError](-unauthorized-error/index.md) : [SuperTokensStatus](index.md) |
| [UnknownEMailError](-unknown-e-mail-error/index.md) | [common]<br>data object [UnknownEMailError](-unknown-e-mail-error/index.md) : [SuperTokensStatus](index.md) |
| [UnknownError](-unknown-error/index.md) | [common]<br>data object [UnknownError](-unknown-error/index.md) : [SuperTokensStatus](index.md) |
| [UnknownPhoneNumberError](-unknown-phone-number-error/index.md) | [common]<br>data object [UnknownPhoneNumberError](-unknown-phone-number-error/index.md) : [SuperTokensStatus](index.md) |
| [UnknownRole](-unknown-role/index.md) | [common]<br>data object [UnknownRole](-unknown-role/index.md) : [SuperTokensStatus](index.md) |
| [UnknownUserIdError](-unknown-user-id-error/index.md) | [common]<br>data object [UnknownUserIdError](-unknown-user-id-error/index.md) : [SuperTokensStatus](index.md) |
| [WrongCredentialsError](-wrong-credentials-error/index.md) | [common]<br>data object [WrongCredentialsError](-wrong-credentials-error/index.md) : [SuperTokensStatus](index.md) |

## Properties

| Name | Summary |
|---|---|
| [value](value.md) | [common]<br>val [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
