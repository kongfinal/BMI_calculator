package com.example.bmicalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bmicalculator.database.BMR

class bmrResultAdapter: RecyclerView.Adapter<bmrResultAdapter.ViewHolder>() {
    var data =  listOf<BMR>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val gender: TextView = itemView.findViewById(R.id.gender_table)
        val age: TextView = itemView.findViewById(R.id.age_table)
        val height: TextView = itemView.findViewById(R.id.height_table)
        val weight: TextView = itemView.findViewById(R.id.weight_table)
        val bmrCost: TextView = itemView.findViewById(R.id.bmr_cost_table)
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.list_item_bmr, parent, false)
                return ViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bindBMR(item)
    }

    private fun ViewHolder.bindBMR(
        item: BMR
    ) {
        val res = itemView.context.resources
        gender.text = item.gender.toString()
        age.text = item.age.toString()
        height.text = item.height.toString()
        weight.text = item.weight.toString()
        bmrCost.text = String.format("%.2f", item.bmrCost)
    }



}