package com.example.demoapi.API

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoapi.MainActivity
import com.example.demoapi.R

class DataAdapter(val mainActivity: MainActivity, val list: List<DataApiModelItem>?) :
    RecyclerView.Adapter<DataAdapter.Viewdata>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewdata {
        var view = LayoutInflater.from(mainActivity).inflate(R.layout.itemfile, parent, false)
        return Viewdata(view)
    }

    override fun onBindViewHolder(holder: Viewdata, position: Int) {
        holder.name_txt.text= list!!.get(position).name
        holder.email_txt.text= list.get(position).email
        holder.body_txt.text= list.get(position).body
        holder.id_txt.text= list.get(position).id.toString()

        Glide.with(mainActivity)  //2
            .load(list?.get(position)!!.postId) //3
            .centerCrop() //4
            .into(holder.image) //8
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    class Viewdata(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.image)
        var name_txt = itemView.findViewById<TextView>(R.id.name_txt)
        var email_txt = itemView.findViewById<TextView>(R.id.email_txt)
        var body_txt = itemView.findViewById<TextView>(R.id.body_txt)
        var id_txt = itemView.findViewById<TextView>(R.id.id_txt)
    }
}