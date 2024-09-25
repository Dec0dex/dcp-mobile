//[composeApp](../../../index.md)/[net.decodex.dcp.core.data](../index.md)/[AppDatabase](index.md)

# AppDatabase

[common]\
abstract class [AppDatabase](index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html), [DB](../-d-b/index.md)

## Constructors

| | |
|---|---|
| [AppDatabase](-app-database.md) | [common]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [invalidationTracker](index.md#-990093491%2FProperties%2F-676342820) | [common]<br>expect val [invalidationTracker](index.md#-990093491%2FProperties%2F-676342820): [InvalidationTracker](https://developer.android.com/reference/kotlin/androidx/room/InvalidationTracker.html) |

## Functions

| Name | Summary |
|---|---|
| [clearAllTables](clear-all-tables.md) | [common]<br>open override fun [clearAllTables](clear-all-tables.md)() |
| [close](index.md#1674273423%2FFunctions%2F-676342820) | [common]<br>expect fun [close](index.md#1674273423%2FFunctions%2F-676342820)() |
| [createAutoMigrations](index.md#1420085996%2FFunctions%2F-676342820) | [common]<br>expect open fun [createAutoMigrations](index.md#1420085996%2FFunctions%2F-676342820)(autoMigrationSpecs: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;, [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Migration](https://developer.android.com/reference/kotlin/androidx/room/migration/Migration.html)&gt; |
| [getRequiredAutoMigrationSpecClasses](index.md#-432702106%2FFunctions%2F-676342820) | [common]<br>expect open fun [getRequiredAutoMigrationSpecClasses](index.md#-432702106%2FFunctions%2F-676342820)(): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;&gt; |
| [getTypeConverter](index.md#2031305957%2FFunctions%2F-676342820) | [common]<br>expect fun &lt;[T](index.md#2031305957%2FFunctions%2F-676342820) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [getTypeConverter](index.md#2031305957%2FFunctions%2F-676342820)(klass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;[T](index.md#2031305957%2FFunctions%2F-676342820)&gt;): [T](index.md#2031305957%2FFunctions%2F-676342820) |
| [getUserDao](get-user-dao.md) | [common]<br>abstract fun [getUserDao](get-user-dao.md)(): [UserDao](../../net.decodex.dcp.features.user.domain.dao/-user-dao/index.md) |
