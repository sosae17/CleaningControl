package com.example.cleaningcontrol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BathroomAdapter(
    private val bathroomList: List<Bathroom>
) : RecyclerView.Adapter<BathroomAdapter.BathroomViewHolder>() {

    class BathroomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textBathroomName: TextView = itemView.findViewById(R.id.textBathroomName)
        val textBathroomShift: TextView = itemView.findViewById(R.id.textBathroomShift)
        val textBathroomStatus: TextView = itemView.findViewById(R.id.textBathroomStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BathroomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bathroom, parent, false)
        return BathroomViewHolder(view)
    }

    override fun onBindViewHolder(holder: BathroomViewHolder, position: Int) {
        val bathroom = bathroomList[position]

        holder.textBathroomName.text = bathroom.name
        holder.textBathroomShift.text = bathroom.shift
        holder.textBathroomStatus.text = bathroom.status
    }

    override fun getItemCount(): Int = bathroomList.size
}
