package com.example.bmicalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bmicalculator.database.BMI

class bmiResultAdapter: RecyclerView.Adapter<bmiResultAdapter.ViewHolder>() {
    var data =  listOf<BMI>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val height: TextView = itemView.findViewById(R.id.height_table)
        val weight: TextView = itemView.findViewById(R.id.weight_table)
        val bmiCost: TextView = itemView.findViewById(R.id.bmi_cost_table)
        val bmiCriterion: TextView = itemView.findViewById(R.id.bmi_criterion_table)
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.list_item_bmi, parent, false)
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
        holder.bindBMI(item)
    }

    private fun ViewHolder.bindBMI(
        item: BMI
    ) {
        val res = itemView.context.resources
        height.text = item.height.toString()
        weight.text = item.weight.toString()
        bmiCost.text = String.format("%.2f", item.bmiCost)
        bmiCriterion.text = item.bmiCriterion
    }



}