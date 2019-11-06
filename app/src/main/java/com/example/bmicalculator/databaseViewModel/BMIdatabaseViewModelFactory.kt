package com.example.bmicalculator.databaseViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bmicalculator.database.BMIDao

class BMIdatabaseViewModelFactory(
    private val dataSource: BMIDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BMIdatabaseViewModel::class.java)) {
            return BMIdatabaseViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}