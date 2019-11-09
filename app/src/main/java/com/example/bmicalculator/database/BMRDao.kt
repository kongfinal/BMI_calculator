package com.example.bmicalculator.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BMRDao {
    @Insert
    fun insert(Ans: BMR)

    @Update
    fun update(Ans: BMR)

    @Query("SELECT * from BMR WHERE BmrId = :key")
    fun get(key: Long): BMR?

    @Query("DELETE FROM BMR")
    fun clear()

    @Query("SELECT * FROM BMR WHERE name = :name")
    fun getBmrByName(name : String): BMR?

    @Query("SELECT * FROM BMR ORDER BY BmrId DESC")
    fun getAllBmr(): LiveData<List<BMR>>
}