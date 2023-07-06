package com.turgunboyevjurabek.startup.adapters



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.turgunboyevjurabek.startup.databinding.ItemGameMainBinding
import com.turgunboyevjurabek.startup.madels.User2

class RvGameMain(val list: ArrayList<User2>,val click: Click):RecyclerView.Adapter<RvGameMain.Vh>() {
    inner class Vh(val itemGameMainBinding: ItemGameMainBinding):ViewHolder(itemGameMainBinding.root){
        fun onBind(user2: User2,position: Int){
            itemGameMainBinding.textItem.text=user2.ismi.toString()
            itemGameMainBinding.conslayaout1.setOnClickListener {
                click.selectGame(position,user2)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemGameMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }
}
interface Click{
    fun selectGame(position: Int,user2: User2)
}