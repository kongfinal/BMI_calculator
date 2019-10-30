package com.example.bmicalculator

import android.util.Log
import androidx.lifecycle.ViewModel

class BmrResultViewModel : ViewModel() {

    init {
        Log.i("BmrResultViewModel", "BmrResultViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("BmrResultViewModel", "BmrResultViewModel destroyed!")
    }
}