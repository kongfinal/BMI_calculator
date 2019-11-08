package com.example.bmicalculator.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BMIDao {
    @Insert
    fun insert(Ans: BMI)

    @Update
    fun update(Ans: BMI)

    @Query("SELECT * from BMI WHERE BmiId = :key")
    fun get(key: Long): BMI?

    @Query("DELETE FROM BMI")
    fun clear()

    @Query("SELECT * FROM BMI WHERE name = :name")
    fun getBmiByName(name : String): BMI?

    @Query("SELECT * FROM BMI ORDER BY BmiId DESC")
    fun getAllBmi(): LiveData<List<BMI>>
}