package com.turgunboyevjurabek.startup.fragment

import User
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.adapters.onClick
import com.turgunboyevjurabek.startup.databinding.FragmentSearchBinding
import com.turgunboyevjurabek.startup.madels.MyObeject

class SearchFragment : Fragment() {
private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }
    private lateinit var rvAdabter: RvAdabter
    private lateinit var list: ArrayList<User>
    private lateinit var dataBase: DataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        loadData()

        binding.searchView.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                val queryy=query?:""
                val list = dataBase.searchItem(queryy)
                rvAdabter.list.clear()
                rvAdabter.list.addAll(list)
                rvAdabter.notifyDataSetChanged()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val queryy=newText?:""
                val list = dataBase.searchItem(queryy)
                rvAdabter.list.clear()
                rvAdabter.list.addAll(list)
                rvAdabter.notifyDataSetChanged()
                return true
            }
        })


        return binding.root
    }

    private fun loadData() {
        dataBase= DataBase(requireContext())
        list= ArrayList()
        list.addAll(dataBase.getItems())

     rvAdabter= RvAdabter(list,object:onClick{
         override fun select(user: User, position: Int) {
             MyObeject.nomi=user.nomi.toString()
             MyObeject.description=user.description.toString()
             MyObeject.gif=user.gifImage
             findNavController().navigate(R.id.itemSearchFragment)
         }
     })
        rvAdabter.notifyDataSetChanged()
        binding.rvSearch.adapter=rvAdabter
    }//
}