@file:OptIn(ExperimentalForeignApi::class)

package net.decodex.dcp.core.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

fun createDataStore(): DataStore<Preferences> {
    return createDataStore {
        val directory =
            NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForNull = null,
                create = false,
                error = null,
            )
        requireNotNull(directory).path + "/$DATA_STORE_FILE_NAME"
    }
}
