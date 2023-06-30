package com.turgunboyevjurabek.startup.adapters

import User
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.turgunboyevjurabek.startup.databinding.ItemRvBinding


class RvAdabter(val list: ArrayList<User>,val onClick: onClick):RecyclerView.Adapter<RvAdabter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding):ViewHolder(itemRvBinding.root){
        fun onBind(user: User,position: Int){
            itemRvBinding.itemName.text=user.nomi.toString()
            itemRvBinding.itemDescription.text=user.description.toString()
            itemRvBinding.itemGif.setImageResource(user.gifImage!!)

            itemRvBinding.card.setOnClickListener {
                onClick.select(user,position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {

        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int=list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }
}
interface onClick{
    fun select(user: User,position: Int)
}