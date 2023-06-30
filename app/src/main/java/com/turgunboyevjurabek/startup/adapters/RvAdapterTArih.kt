package com.turgunboyevjurabek.startup.adapters

import User
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.databinding.ItemrvTarihBinding
import com.turgunboyevjurabek.startup.madels.MyObeject

class RvAdapterTArih(val list: ArrayList<User>):RecyclerView.Adapter<RvAdapterTArih.Vh>() {
    inner class Vh(val itemrvTarihBinding: ItemrvTarihBinding):ViewHolder(itemrvTarihBinding.root){
        fun onBind(user: User){

            itemrvTarihBinding.thtItemName.text=user.Gnomi.toString()
            itemrvTarihBinding.thtTime.text=user.gameMemory
            itemrvTarihBinding.thtItemTrue.text= user.gameTrue?.toInt().toString()
            itemrvTarihBinding.thtItemFalse.text=user.gameFalse?.toInt().toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemrvTarihBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

}