//[composeApp](../../../index.md)/[net.decodex.dcp.features.login.presentation](../index.md)/[LoginEvent](index.md)

# LoginEvent

sealed interface [LoginEvent](index.md)

#### Inheritors

| |
|---|
| [OnLoginClick](-on-login-click/index.md) |
| [OnEmailChanged](-on-email-changed/index.md) |
| [OnPasswordChanged](-on-password-changed/index.md) |
| [OnRegisterClicked](-on-register-clicked/index.md) |
| [OnForgotPasswordClicked](-on-forgot-password-clicked/index.md) |
| [SignInWithGoogle](-sign-in-with-google/index.md) |
| [SignInWithFacebook](-sign-in-with-facebook/index.md) |
| [SignInWithGitHub](-sign-in-with-git-hub/index.md) |
| [SignInWithApple](-sign-in-with-apple/index.md) |
| [DismissErrorDialog](-dismiss-error-dialog/index.md) |

## Types

| Name | Summary |
|---|---|
| [DismissErrorDialog](-dismiss-error-dialog/index.md) | [common]<br>data object [DismissErrorDialog](-dismiss-error-dialog/index.md) : [LoginEvent](index.md) |
| [OnEmailChanged](-on-email-changed/index.md) | [common]<br>data class [OnEmailChanged](-on-email-changed/index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [LoginEvent](index.md) |
| [OnForgotPasswordClicked](-on-forgot-password-clicked/index.md) | [common]<br>data object [OnForgotPasswordClicked](-on-forgot-password-clicked/index.md) : [LoginEvent](index.md) |
| [OnLoginClick](-on-login-click/index.md) | [common]<br>data object [OnLoginClick](-on-login-click/index.md) : [LoginEvent](index.md) |
| [OnPasswordChanged](-on-password-changed/index.md) | [common]<br>data class [OnPasswordChanged](-on-password-changed/index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [LoginEvent](index.md) |
| [OnRegisterClicked](-on-register-clicked/index.md) | [common]<br>data object [OnRegisterClicked](-on-register-clicked/index.md) : [LoginEvent](index.md) |
| [SignInWithApple](-sign-in-with-apple/index.md) | [common]<br>data object [SignInWithApple](-sign-in-with-apple/index.md) : [LoginEvent](index.md) |
| [SignInWithFacebook](-sign-in-with-facebook/index.md) | [common]<br>data object [SignInWithFacebook](-sign-in-with-facebook/index.md) : [LoginEvent](index.md) |
| [SignInWithGitHub](-sign-in-with-git-hub/index.md) | [common]<br>data object [SignInWithGitHub](-sign-in-with-git-hub/index.md) : [LoginEvent](index.md) |
| [SignInWithGoogle](-sign-in-with-google/index.md) | [common]<br>data object [SignInWithGoogle](-sign-in-with-google/index.md) : [LoginEvent](index.md) |
