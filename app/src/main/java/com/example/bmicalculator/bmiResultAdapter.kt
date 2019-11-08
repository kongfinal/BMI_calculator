package com.example.bmicalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bmicalculator.database.BMI

class bmiResultAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
    var data =  listOf<BMI>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_bmi_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.bmiQuality.toString()
    }

}