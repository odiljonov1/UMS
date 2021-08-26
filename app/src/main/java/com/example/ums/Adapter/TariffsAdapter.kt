package com.example.ums.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ums.Models.TarifModel
import com.example.ums.R
import kotlinx.android.synthetic.main.tariffs_item.view.*

class TariffsAdapter(var context: Context, var list: ArrayList<TarifModel>) : RecyclerView.Adapter<TariffsAdapter.MyViewHolder>() {

    inner class MyViewHolder(var itemView2: View) : RecyclerView.ViewHolder(itemView2) {
        fun onBind(position: Int) {
            itemView2.tariffs_name.text = list[position].name
            itemView2.tariffs_code.text = list[position].code
            itemView2.tariffs_desc.text = list[position].desc

            itemView2.setOnClickListener{
                val navOption = NavOptions.Builder()
                navOption.setEnterAnim(R.anim.anim_enter)
                itemView.findNavController().navigate(R.id.infoFragment, bundleOf("keyName" to list[position].name, "keyCode" to list[position].code, "keyDesc" to list[position].desc), navOption.build())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tariffs_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}