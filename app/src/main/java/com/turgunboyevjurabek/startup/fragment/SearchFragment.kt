package com.turgunboyevjurabek.startup.fragment

import User
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.Click2
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.adapters.RvSearch
import com.turgunboyevjurabek.startup.adapters.onClick
import com.turgunboyevjurabek.startup.databinding.FragmentSearchBinding
import com.turgunboyevjurabek.startup.madels.MyObeject

class SearchFragment : Fragment() {
private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }
    private lateinit var list: ArrayList<User>
    private lateinit var rvSearch: RvSearch
    private lateinit var list2: ArrayList<User>
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
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        loadData()
        binding.searchView.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                val queryy=query?:""
                val listSearch = dataBase.searchItem(queryy)
                rvSearch.list.clear()
                rvSearch.list.addAll(listSearch)
                rvSearch.notifyDataSetChanged()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                val queryy=newText?:""
                val listSearch2 = dataBase.searchItem(queryy)
                rvSearch.list.clear()
                rvSearch.list.addAll(listSearch2)
                rvSearch.notifyDataSetChanged()
                return true
            }

        })
        loadData()
    }
    private fun loadData() {
        dataBase= DataBase(requireContext())
        list= ArrayList()
        list2= ArrayList()
        list.addAll(dataBase.NotEquelse(""))

     rvSearch = RvSearch(list,object :Click2{
         override fun click(userGuruh: User, position: Int) {
             MyObeject.nomi=userGuruh.nomi.toString()
             MyObeject.description=userGuruh.description.toString()
             MyObeject.gif=userGuruh.gifImage
             findNavController().navigate(R.id.itemSearchFragment)
         }
     })
        binding.rvSearch.adapter=rvSearch
    }//
}