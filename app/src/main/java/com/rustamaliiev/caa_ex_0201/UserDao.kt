package com.rustamaliiev.caa_ex_0201

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getUsers(): Flow<List<RoomUser>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<RoomUser>)

}