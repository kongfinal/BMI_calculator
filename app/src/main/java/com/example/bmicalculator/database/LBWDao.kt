package com.example.bmicalculator.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LBWDao {
    @Insert
    fun insert(Ans: LBW)

    @Update
    fun update(Ans: LBW)

    @Query("SELECT * from LBW WHERE lbwId = :key")
    fun get(key: Long): LBW?

    @Query("DELETE FROM LBW")
    fun clear()

    @Query("SELECT * FROM LBW WHERE name = :name")
    fun getLbwByName(name : String): LBW?

    @Query("SELECT * FROM LBW ORDER BY lbwId DESC")
    fun getAllLbw(): LiveData<List<LBW>>
}