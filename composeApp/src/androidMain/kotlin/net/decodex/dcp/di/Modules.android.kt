package net.decodex.dcp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import net.decodex.dcp.core.data.AppDatabase
import net.decodex.dcp.core.data.createDataStore
import net.decodex.dcp.core.data.getDatabase
import org.koin.dsl.module

actual val platformModule =
    module {
        single<DataStore<Preferences>> { createDataStore(get<Context>()) }
        single<AppDatabase> { getDatabase(get<Context>()) }
    }
