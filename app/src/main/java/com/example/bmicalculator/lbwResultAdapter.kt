package com.example.bmicalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bmicalculator.database.LBW

class lbwResultAdapter: RecyclerView.Adapter<lbwResultAdapter.ViewHolder>() {
    var data =  listOf<LBW>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val gender: TextView = itemView.findViewById(R.id.gender_table)
        val height: TextView = itemView.findViewById(R.id.height_table)
        val weight: TextView = itemView.findViewById(R.id.weight_table)
        val sbwCost: TextView = itemView.findViewById(R.id.sbw_cost_table)
        val fatWCost: TextView = itemView.findViewById(R.id.fw_cost_table)
        val sbwCriterionCost: TextView = itemView.findViewById(R.id.sbw_criterion_table)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_lbw, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        holder.gender.text = item.gender.toString()
        holder.height.text = item.height.toString()
        holder.weight.text = item.weight.toString()
        holder.sbwCost.text = String.format("%.1f", item.sbwCost)
        holder.fatWCost.text = String.format("%.1f", item.fatWCost)
        holder.sbwCriterionCost.text = item.lbwCriterion.toString()
    }


}