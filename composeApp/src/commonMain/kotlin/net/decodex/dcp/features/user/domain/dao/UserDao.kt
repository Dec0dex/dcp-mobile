package net.decodex.dcp.features.user.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import net.decodex.dcp.features.user.domain.entities.User

@Dao
interface UserDao {
    @Upsert
    suspend fun upsert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM user WHERE id=:id")
    fun findById(id: String): Flow<User>

    @Query("SELECT * FROM user")
    fun findAll(): Flow<List<User>>
}
