//[composeApp](../../../index.md)/[net.decodex.dcp.core.supertokens.recipes.core.repositories](../index.md)/[SuperTokensUserRepository](index.md)

# SuperTokensUserRepository

interface [SuperTokensUserRepository](index.md)

#### Inheritors

| |
|---|
| [SuperTokensUserRepositoryImpl](../-super-tokens-user-repository-impl/index.md) |

## Properties

| Name | Summary |
|---|---|
| [superTokensUser](super-tokens-user.md) | [common]<br>abstract val [superTokensUser](super-tokens-user.md): StateFlow&lt;[SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)?&gt; |

## Functions

| Name | Summary |
|---|---|
| [getUser](get-user.md) | [common]<br>abstract suspend fun [getUser](get-user.md)(): [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)? |
| [updateUser](update-user.md) | [common]<br>abstract suspend fun [updateUser](update-user.md)(user: [SuperTokensUser](../../net.decodex.dcp.core.supertokens.models/-super-tokens-user/index.md)?) |
