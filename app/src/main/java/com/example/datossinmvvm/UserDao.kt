package com.example.datossinmvvm

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM User ORDER BY uid DESC LIMIT 1")
    suspend fun getLastUser(): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)
}
