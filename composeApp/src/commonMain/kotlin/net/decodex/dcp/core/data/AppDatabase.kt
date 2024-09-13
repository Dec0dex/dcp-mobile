package net.decodex.dcp.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import net.decodex.dcp.user.domain.dao.UserDao
import net.decodex.dcp.user.domain.entities.User

@Database(
    entities = [User::class],
    version = 1,
)
abstract class AppDatabase : RoomDatabase(), DB {
    abstract fun getUserDao(): UserDao

    override fun clearAllTables() {
        super.clearAllTables()
    }
}

// FIXME: Added a hack to resolve below issue:
// Class 'AppDatabase_Impl' is not abstract and does not implement abstract base class member 'clearAllTables'.
interface DB {
    fun clearAllTables() {}
}
