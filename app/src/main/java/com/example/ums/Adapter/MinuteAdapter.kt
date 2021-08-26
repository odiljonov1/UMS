package com.example.ums.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ums.Models.MinutesModel
import com.example.ums.R
import kotlinx.android.synthetic.main.minutes_item.view.*

class MinutesAdapter(var context: Context, var list: ArrayList<MinutesModel>) : RecyclerView.Adapter<MinutesAdapter.MyViewHolder>() {

    inner class MyViewHolder(var itemView3: View) : RecyclerView.ViewHolder(itemView3) {
        fun onBind(model: MinutesModel, position: Int) {
            itemView3.minutes_minutes.text = list[position].minutes
            itemView3.minutes_code.text = list[position].code
            itemView3.minutes_desc.text = list[position].desc

            itemView3.setOnClickListener{
                val navOption = NavOptions.Builder()
                navOption.setEnterAnim(R.anim.exit_anim)
                itemView.findNavController().navigate(R.id.infoFragment, bundleOf("minutesMinutes" to list[position].minutes, "minutesCode" to list[position].code, "minutesDesc" to list[position].desc), navOption.build())
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.minutes_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}