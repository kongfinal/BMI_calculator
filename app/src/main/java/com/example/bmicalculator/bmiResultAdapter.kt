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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val height: TextView = itemView.findViewById(R.id.height_table)
        val weight: TextView = itemView.findViewById(R.id.weight_table)
        val bmiCost: TextView = itemView.findViewById(R.id.bmi_cost_table)
        val bmiCriterion: TextView = itemView.findViewById(R.id.bmi_criterion_table)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_bmi, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        holder.height.text = item.height.toString()
        holder.weight.text = item.weight.toString()
        holder.bmiCost.text = String.format("%.2f", item.bmiCost)
        holder.bmiCriterion.text = item.bmiCriterion
    }

}