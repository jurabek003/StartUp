package com.turgunboyevjurabek.startup.adapters
import User
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.turgunboyevjurabek.startup.databinding.ItemViewBinding

class MyPagerAdapter(val list: List<User>) :
    RecyclerView.Adapter<MyPagerAdapter.Vh>() {
    inner class Vh(val itemViewBinding: ItemViewBinding) : ViewHolder(itemViewBinding.root) {
        fun onBind(user: User,position: Int) {
            itemViewBinding.selectName.text=user.nomi.toString()
            itemViewBinding.selectDescription.text=user.description.toString()
            itemViewBinding.selectGif.setImageURI(Uri.parse(user.gifImage))
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }
}