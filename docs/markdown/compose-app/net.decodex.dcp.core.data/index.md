//[composeApp](../../index.md)/[net.decodex.dcp.core.data](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AppDatabase](-app-database/index.md) | [common]<br>abstract class [AppDatabase](-app-database/index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html), [DB](-d-b/index.md) |
| [DB](-d-b/index.md) | [common]<br>interface [DB](-d-b/index.md) |

## Functions

| Name | Summary |
|---|---|
| [createDataStore](create-data-store.md) | [ios, android, common]<br>[ios]<br>fun [createDataStore](create-data-store.md)(): &lt;Error class: unknown class&gt;&lt;&lt;Error class: unknown class&gt;&gt;<br>[android]<br>fun [createDataStore](create-data-store.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt;<br>[common]<br>fun [createDataStore](create-data-store.md)(producePath: () -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DataStore](https://developer.android.com/reference/kotlin/androidx/datastore/core/DataStore.html)&lt;[Preferences](https://developer.android.com/reference/kotlin/androidx/datastore/preferences/core/Preferences.html)&gt; |
| [getDatabase](get-database.md) | [ios, android]<br>[ios]<br>fun [getDatabase](get-database.md)(): &lt;Error class: unknown class&gt;<br>[android]<br>fun [getDatabase](get-database.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [AppDatabase](-app-database/index.md) |
