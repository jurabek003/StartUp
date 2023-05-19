package com.turgunboyevjurabek.startup.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.databinding.FragmentSearchBinding
import com.turgunboyevjurabek.startup.madels.MyObeject
import com.turgunboyevjurabek.startup.madels.User

class SearchFragment : Fragment() {
private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }
    private lateinit var rvAdabter: RvAdabter
    private lateinit var list: ArrayList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        loadData()
        return binding.root
    }

    private fun loadData() {

//        list=java.util.ArrayList()
//        list.addAll(listHarf)
//        rvAdabter=RvAdabter()

    }
}