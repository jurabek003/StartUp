package com.turgunboyevjurabek.startup.adapters



import User
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.databinding.ItemGameMainBinding
import com.turgunboyevjurabek.startup.madels.User2
import java.text.SimpleDateFormat
import java.util.Date

class RvGameMain(val context: Context, val list: ArrayList<User2>,val click: Click):RecyclerView.Adapter<RvGameMain.Vh>() {
    inner class Vh(val itemGameMainBinding: ItemGameMainBinding):ViewHolder(itemGameMainBinding.root){
        val timeDay = SimpleDateFormat("dd:MM:yyyy").format(Date())
        val list2=ArrayList<User>()
        val dataBase=DataBase(context)
        val count=dataBase.getItems()

        fun onBind(user2: User2,position: Int){
            itemGameMainBinding.textItem.text=user2.ismi.toString()

            for (i in 0 until list.size ){
                list2.addAll(dataBase.gameSelectItem(i+1))
            }
            for (i in 0 until list.size){
                list[i].cup1+=list2[i].gameTrue?.toInt()!!
                list[i].cup2+=list2[i].gameFalse?.toInt()!!
            }
            itemGameMainBinding.conslayaout1.setOnClickListener {
                click.selectGame(position,user2)
            }
            itemGameMainBinding.trueCount.text=user2.cup1.toInt().toString()
            itemGameMainBinding.falseCount.text=user2.cup2.toInt().toString()
            if(user2.cup in 0 ..2){
                itemGameMainBinding.imageCup.setImageResource(R.drawable.cup3th)
            }else if (user2.cup in 3..5){
                itemGameMainBinding.imageCup.setImageResource(R.drawable.cup2th)
            }else{
                itemGameMainBinding.imageCup.setImageResource(R.drawable.cup1th)
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