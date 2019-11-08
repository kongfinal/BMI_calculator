package com.example.bmicalculator

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class bmiResultViewModel : ViewModel() {

    init {
        Log.i("bmiResultViewModel", "bmiResultViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("bmiResultViewModel", "bmiResultViewModel destroyed!")
    }
}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)