package com.example.bmicalculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel : ViewModel() {

    private var _showSnackBarName = MutableLiveData<Boolean>()

    val showSnackBarName: LiveData<Boolean>
        get() = _showSnackBarName

    init {

        Log.i("TitleViewModel", "TitleViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("TitleViewModel", "TitleViewModel destroyed!")
    }

    fun doneShowingSnackbarName() {
        _showSnackBarName.value = false
    }
}