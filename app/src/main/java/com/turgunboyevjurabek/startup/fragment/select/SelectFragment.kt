package com.turgunboyevjurabek.startup.fragment.select

import User
import android.annotation.SuppressLint
import android.app.ActionBar.LayoutParams
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import androidx.core.view.get
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.MyPagerAdapter
import com.turgunboyevjurabek.startup.databinding.FragmentSelectBinding
import com.turgunboyevjurabek.startup.databinding.ItemTabBinding
import com.turgunboyevjurabek.startup.databinding.ItemViewBinding
import com.turgunboyevjurabek.startup.madels.MyObeject


class SelectFragment : Fragment() {
    private val binding by lazy { FragmentSelectBinding.inflate(layoutInflater) }
    private lateinit var myPagerAdapter: MyPagerAdapter
    private lateinit var list2: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        loadData()

        return binding.root
    }
    @SuppressLint("ResourceAsColor")
    private fun loadData() {
     list2=arguments?.getSerializable("key11") as ArrayList<User>
        val positions=arguments?.getInt("keyP")

        myPagerAdapter=MyPagerAdapter(list2)
        binding.myViewpager2.adapter=myPagerAdapter

        TabLayoutMediator(binding.tabLayout,binding.myViewpager2){tab, position->
            val itemTabBinding=ItemTabBinding.inflate(layoutInflater)
            tab.text=list2[position].nomi
            itemTabBinding.textTab.text=list2[position].nomi.toString()
            tab.customView=itemTabBinding.root
        }.attach()

        val tabCount=binding.tabLayout.tabCount
        for (i in 0 until tabCount){
            val itemTabBinding=ItemTabBinding.inflate(layoutInflater)
            val tab=binding.tabLayout.getTabAt(i)
            tab?.customView = itemTabBinding.root
        }
        binding.myViewpager2.setCurrentItem(positions!!)

        binding.tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val itemTabBinding = ItemTabBinding.inflate(layoutInflater)
                itemTabBinding.textTab.text=list2[tab?.position!!].nomi
                itemTabBinding.tabLiner.setBackgroundResource(R.color.card)
                itemTabBinding.textTab.setTextColor(R.color.white)
                tab?.setCustomView(itemTabBinding.root)
            }

            @SuppressLint("ResourceAsColor")
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val itemTabBinding = ItemTabBinding.inflate(layoutInflater)
                itemTabBinding.textTab.text=list2[tab?.position!!].nomi
                tab?.setCustomView(itemTabBinding.root)
            }

            @SuppressLint("ResourceAsColor")
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        myPagerAdapter.notifyDataSetChanged()
    }
}