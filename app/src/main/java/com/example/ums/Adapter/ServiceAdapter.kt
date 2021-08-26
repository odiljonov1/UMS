package com.example.ums.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ums.Models.ServicesModel
import com.example.ums.R
import kotlinx.android.synthetic.main.sevices_layout.view.*

class ServicesAdapter(var context: Context, var list: ArrayList<ServicesModel>, var itemClick: ItemClick4) : RecyclerView.Adapter<ServicesAdapter.MyViewHolder>() {

    inner class MyViewHolder(var itemView4: View) : RecyclerView.ViewHolder(itemView4) {
        fun onBind(model: ServicesModel, position: Int) {
            itemView4.services_name.text = list[position].name
            itemView4.services_code.text = list[position].code

            itemView.setOnClickListener {
                itemClick.onClick(list, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.sevices_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}


interface ItemClick4{
    fun onClick(list: ArrayList<ServicesModel>, position: Int)
}