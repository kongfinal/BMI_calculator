package com.example.bmicalculator.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BMI::class], version = 1, exportSchema = false)
abstract class BMIDatabase : RoomDatabase() {
    abstract val BMIDao: BMIDao

    companion object {

        @Volatile
        private var INSTANCE: BMIDatabase? = null

        fun getInstance(context: Context): BMIDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BMIDatabase::class.java,
                        "bmi_history_database"
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