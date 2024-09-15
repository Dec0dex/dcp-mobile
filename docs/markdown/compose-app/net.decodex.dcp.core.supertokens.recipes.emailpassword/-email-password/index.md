//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.emailpassword](../index.md)/[EmailPassword](index.md)

# EmailPassword

[common]\
object [EmailPassword](index.md) : [RecipeBuilder](../../net.decodex.dcp.core.supertokens.recipes/-recipe-builder/index.md)&lt;[EmailPasswordConfig](../-email-password-config/index.md), [EmailPasswordRecipe](../-email-password-recipe/index.md)&gt; , [SignInProvider](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider/index.md)&lt;[EmailPassword.Config](-config/index.md), [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)&gt; , [SignUpProvider](../../net.decodex.dcp.core.supertokens.handlers/-sign-up-provider/index.md)&lt;[EmailPassword.Config](-config/index.md), [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Config](-config/index.md) | [common]<br>data class [Config](-config/index.md)(var email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, var password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [SignInProviderConfig](../../net.decodex.dcp.core.supertokens.handlers/-sign-in-provider-config/index.md), [SignUpProviderConfig](../../net.decodex.dcp.core.supertokens.handlers/-sign-up-provider-config/index.md) |

## Functions

| Name | Summary |
|---|---|
| [install](install.md) | [common]<br>open override fun [install](install.md)(configure: [EmailPasswordConfig](../-email-password-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): ([SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md)) -&gt; [EmailPasswordRecipe](../-email-password-recipe/index.md) |
| [signIn](sign-in.md) | [common]<br>open suspend override fun [signIn](sign-in.md)(superTokensClient: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), configure: [EmailPassword.Config](-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md) |
| [signUp](sign-up.md) | [common]<br>open suspend override fun [signUp](sign-up.md)(superTokensClient: [SuperTokensClient](../../net.decodex.dcp.core.supertokens/-super-tokens-client/index.md), configure: [EmailPassword.Config](-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md) |
