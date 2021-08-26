package com.example.ums.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ums.Models.SmsModel
import com.example.ums.R
import kotlinx.android.synthetic.main.sms_item.view.*

class SmsAdapter( var list: ArrayList<SmsModel>, var itemClick: ItemClick3) :
    RecyclerView.Adapter<SmsAdapter.MyViewHolder>() {

    inner class MyViewHolder(var itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun onBind(model: SmsModel, position: Int) {
            itemview.sms_name.text = list[position].name
            itemview.sms_code.text = list[position].code
            itemview.sms_desc.text = list[position].desc

            itemview.setOnClickListener {
                itemClick.onClick(list, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.sms_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
interface ItemClick3{
    fun onClick(list: ArrayList<SmsModel>, position: Int)
}