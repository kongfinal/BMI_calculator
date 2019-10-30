package com.example.bmicalculator.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BMI")
data class BMI(
    @PrimaryKey(autoGenerate = true)
    var BmiId:  Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "height")
    var height: Double = 0.0,

    @ColumnInfo(name = "weight")
    var weight: Double = 0.0,

    @ColumnInfo(name = "bmiCost")
    var bmiCost: Double = 0.0,

    @ColumnInfo(name = "bmiCriterion")
    var bmiCriterion: String = "",

    @ColumnInfo(name = "quality_rating")
    var bmiQuality: Int = -1
)