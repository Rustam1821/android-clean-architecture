package com.rustamaliiev.caa_ex_0201

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RoomUser::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}