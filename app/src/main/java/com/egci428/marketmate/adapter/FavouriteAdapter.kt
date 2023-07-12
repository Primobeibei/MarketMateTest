package com.egci428.marketmate.adapter

import android.content.Context
import android.content.Intent
import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.egci428.marketmate.MainActivity
import com.egci428.marketmate.R
import com.egci428.marketmate.dataclass.Favourite


class FavouriteAdapter (val favouriteObjects: ArrayList<Favourite>): RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>(){

    private lateinit var clickListener: onItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent,false)
        return FavouriteViewHolder(itemView,clickListener)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        var favouriteOB = favouriteObjects.get(position)
        holder.draftView.text = favouriteObjects[position].message
        holder.statusView.text = favouriteObjects[position].status
    }

    interface onItemClickListener{
        fun clickedItem(favouriteOB: Int)
    }



    override fun getItemCount(): Int {
        return favouriteObjects.size
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        clickListener = listener
    }


    class FavouriteViewHolder(itemView: View,listener: FavouriteAdapter.onItemClickListener): RecyclerView.ViewHolder(itemView){
        var draftView = itemView.findViewById<TextView>(R.id.draftView)
        var statusView = itemView.findViewById<TextView>(R.id.statusView)

        init {
            itemView.setOnClickListener {
                listener.clickedItem(adapterPosition)
            }
        }
    }
}
