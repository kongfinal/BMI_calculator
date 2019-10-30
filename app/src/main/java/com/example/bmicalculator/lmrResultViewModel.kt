package com.example.bmicalculator

import android.util.Log
import androidx.lifecycle.ViewModel

class lmrResultViewModel : ViewModel() {

    init {
        Log.i("lmrResultViewModel", "lmrResultViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("lmrResultViewModel", "lmrResultViewModel destroyed!")
    }
}