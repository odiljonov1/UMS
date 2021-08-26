package com.example.ums.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ums.Models.NewsModel
import com.example.ums.R
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter (var list: ArrayList<NewsModel>, var itemClick: ItemClick1) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    inner class MyViewHolder(var itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun onBind(position: Int) {
            itemview.text_view_news_item_1.text = list[position].text
            itemview.buttonBatafsil1.text = "More read"

            itemview.buttonBatafsil1.setOnClickListener {
                itemClick.onClick(list, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
interface ItemClick1{
    fun onClick(list: ArrayList<NewsModel>, position: Int)
}

