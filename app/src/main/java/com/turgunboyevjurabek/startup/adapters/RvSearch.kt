package com.turgunboyevjurabek.startup.adapters

import User
import com.turgunboyevjurabek.startup.databinding.ItemRvBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RvSearch(val list: ArrayList<User>,val click2: Click2) :
    RecyclerView.Adapter<RvSearch.Vh>() {
    inner class Vh(val itemrvbinding: ItemRvBinding) : ViewHolder(itemrvbinding.root) {
        fun onBind(userGuruh: User,position: Int) {
            if (!userGuruh.nomi.equals("")){
                itemrvbinding.itemName.text=userGuruh.nomi
            }
            itemrvbinding.root.setOnClickListener {
                click2.click(userGuruh, position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

}
interface Click2{
    fun click(userGuruh: User,position: Int)
}