package com.example.colorquest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val names:List<String>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater:LayoutInflater=LayoutInflater.from(parent.context)

        val view:View=inflater.inflate(R.layout.data,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt.text=names[position]
    }

    override fun getItemCount(): Int {
        return names.size
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val txt:TextView=itemView.findViewById(R.id.data)
    }
}