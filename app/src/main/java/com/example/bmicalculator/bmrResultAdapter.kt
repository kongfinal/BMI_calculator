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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val gender: TextView = itemView.findViewById(R.id.gender_table)
        val age: TextView = itemView.findViewById(R.id.age_table)
        val height: TextView = itemView.findViewById(R.id.height_table)
        val weight: TextView = itemView.findViewById(R.id.weight_table)
        val bmrCost: TextView = itemView.findViewById(R.id.bmr_cost_table)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_bmr, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        holder.gender.text = item.gender.toString()
        holder.age.text = item.age.toString()
        holder.height.text = item.height.toString()
        holder.weight.text = item.weight.toString()
        holder.bmrCost.text = String.format("%.2f", item.bmrCost)
    }

}