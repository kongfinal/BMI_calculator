package com.example.bmicalculator.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BMI")
data class LRW(
    @PrimaryKey(autoGenerate = true)
    var LrwId:  Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "gender")
    var gender: String = "",

    @ColumnInfo(name = "height")
    var height: Double = 0.0,

    @ColumnInfo(name = "weight")
    var weight: Double = 0.0,

    @ColumnInfo(name = "sbwCost")
    var sbwCost: Double = 0.0,

    @ColumnInfo(name = "fatWCost")
    var fatWCost: Double = 0.0,

    @ColumnInfo(name = "lbwCriterion")
    var lbwCriterion: String = ""

)