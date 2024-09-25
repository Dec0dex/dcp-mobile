//[composeApp](../../../index.md)/[net.decodex.dcp.features.user.domain.dao](../index.md)/[UserDao](index.md)

# UserDao

[common]\
interface [UserDao](index.md)

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [common]<br>abstract suspend fun [delete](delete.md)(user: [User](../../net.decodex.dcp.features.user.domain.entities/-user/index.md)) |
| [findAll](find-all.md) | [common]<br>abstract fun [findAll](find-all.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[User](../../net.decodex.dcp.features.user.domain.entities/-user/index.md)&gt;&gt; |
| [findById](find-by-id.md) | [common]<br>abstract fun [findById](find-by-id.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[User](../../net.decodex.dcp.features.user.domain.entities/-user/index.md)&gt; |
| [upsert](upsert.md) | [common]<br>abstract suspend fun [upsert](upsert.md)(user: [User](../../net.decodex.dcp.features.user.domain.entities/-user/index.md)) |
