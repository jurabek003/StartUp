package com.turgunboyevjurabek.startup.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.turgunboyevjurabek.startup.databinding.ItemRvMainBinding
import com.turgunboyevjurabek.startup.madels.User2

class RvAdapterMain(var list: ArrayList<User2>):RecyclerView.Adapter<RvAdapterMain.Vh>() {
    inner class Vh(val itemRvMainBinding: ItemRvMainBinding):ViewHolder(itemRvMainBinding.root){
        fun onBind( user2: User2){
            itemRvMainBinding.thtCount.text=user2.id?.toInt().toString()
            itemRvMainBinding.thtName.text=user2.ismi.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}