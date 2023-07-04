package com.turgunboyevjurabek.startup.fragment.Itemlar

import User
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.databinding.FragmentItemSearchBinding
import com.turgunboyevjurabek.startup.madels.MyObeject

class ItemSearchFragment : Fragment() {
    private  val binding by lazy { FragmentItemSearchBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        if (MyObeject.gif!=null && MyObeject.nomi!=null && MyObeject.description!=null){
            binding.searchName.setText(MyObeject.nomi.toString())
            binding.selectGif.setImageURI(Uri.parse(MyObeject.gif))
            binding.searchDescription.setText(MyObeject.description)
        }

        val kalit1=arguments?.getString("k1")
        val kalit2=arguments?.getString("k2")
        val kalit3=arguments?.getInt("k3")
        if (!kalit1.equals(null) && !kalit2.equals(null) ){
            binding.searchName.setText(kalit1)
            binding.selectGif.setImageResource(kalit3!!)
            binding.searchDescription.setText(kalit2)
        }

        return binding.root
    }
}