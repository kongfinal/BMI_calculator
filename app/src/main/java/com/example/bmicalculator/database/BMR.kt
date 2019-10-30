package com.example.bmicalculator.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BMI")
data class BMR(
    @PrimaryKey(autoGenerate = true)
    var BmrId:  Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "gender")
    var gender: String = "",

    @ColumnInfo(name = "age")
    var age: Int = 0,

    @ColumnInfo(name = "height")
    var height: Double = 0.0,

    @ColumnInfo(name = "weight")
    var weight: Double = 0.0,

    @ColumnInfo(name = "bmrCost")
    var bmrCost: Double = 0.0

)