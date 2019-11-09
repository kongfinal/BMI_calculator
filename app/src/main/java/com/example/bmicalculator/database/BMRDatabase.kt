package com.example.bmicalculator.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BMR::class], version = 1, exportSchema = false)
abstract class BMRDatabase : RoomDatabase() {
    abstract val BMRDao: BMRDao

    companion object {

        @Volatile
        private var INSTANCE: BMRDatabase? = null

        fun getInstance(context: Context): BMRDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BMRDatabase::class.java,
                        "bmr_history_database"
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