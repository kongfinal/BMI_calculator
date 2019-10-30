package com.example.bmicalculator

import android.util.Log
import androidx.lifecycle.ViewModel

class bmiResultViewModel : ViewModel() {
    init {
        Log.i("bmiResultViewModel", "bmiResultViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("bmiResultViewModel", "bmiResultViewModel destroyed!")
    }
}