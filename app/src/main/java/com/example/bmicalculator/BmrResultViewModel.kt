package com.example.bmicalculator

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class BmrResultViewModel : ViewModel() {

    init {
        Log.i("BmrResultViewModel", "BmrResultViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("BmrResultViewModel", "BmrResultViewModel destroyed!")
    }
}

class TextItemViewHolderBmr(val textView: TextView): RecyclerView.ViewHolder(textView)