package com.example.bmicalculator.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LBW::class], version = 1, exportSchema = false)
abstract class LBWDatabase : RoomDatabase() {
    abstract val LBWDao: LBWDao

    companion object {

        @Volatile
        private var INSTANCE: LBWDatabase? = null

        fun getInstance(context: Context): LBWDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LBWDatabase::class.java,
                        "lbw_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}