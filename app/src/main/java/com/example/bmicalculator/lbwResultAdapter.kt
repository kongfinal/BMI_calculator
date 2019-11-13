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

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val gender: TextView = itemView.findViewById(R.id.gender_table)
        val height: TextView = itemView.findViewById(R.id.height_table)
        val weight: TextView = itemView.findViewById(R.id.weight_table)
        val sbwCost: TextView = itemView.findViewById(R.id.sbw_cost_table)
        val fatWCost: TextView = itemView.findViewById(R.id.fw_cost_table)
        val sbwCriterionCost: TextView = itemView.findViewById(R.id.sbw_criterion_table)
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.list_item_lbw, parent, false)
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
        holder.bindLBE(item)
    }

    private fun ViewHolder.bindLBE(
        item: LBW
    ) {
        gender.text = item.gender.toString()
        height.text = item.height.toString()
        weight.text = item.weight.toString()
        sbwCost.text = String.format("%.1f", item.sbwCost)
        fatWCost.text = String.format("%.1f", item.fatWCost)
        sbwCriterionCost.text = item.lbwCriterion.toString()
    }




}