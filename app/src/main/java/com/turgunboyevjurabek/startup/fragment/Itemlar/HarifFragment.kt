package com.turgunboyevjurabek.startup.fragment.Itemlar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.adapters.onClick
import com.turgunboyevjurabek.startup.databinding.FragmentHarifBinding
import com.turgunboyevjurabek.startup.fragment.HomeFragment
import com.turgunboyevjurabek.startup.fragment.SearchFragment
import com.turgunboyevjurabek.startup.madels.MyObeject
import com.turgunboyevjurabek.startup.madels.User

class HarifFragment : Fragment() {
    private val binding by lazy { FragmentHarifBinding.inflate(layoutInflater) }
    private lateinit var rvAdabter: RvAdabter
    private lateinit var list: ArrayList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding.btnAmaliy.setOnClickListener {
            findNavController().navigate(R.id.gameFragment, bundleOf("key12" to list))
        }
        binding.btnUrganish.setOnClickListener {
            findNavController().navigate(R.id.selectFragment, bundleOf("key11" to list))
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list= ArrayList()
        list.addAll(listOf(
            User("A","A harifi.",R.drawable.mygif),
            User("B","B harifi.",R.drawable.gif1),
            User("D","D harifi.",R.drawable.gif2),
            User("E","E harifi.",R.drawable.gif3),
            User("F","F harifi.",R.drawable.gif4),
            User("G","G harifi.",R.drawable.gif5),
            User("H","H harifi.",R.drawable.gif6),
            User("I","I harifi.",R.drawable.gif7),
            User("J","J harifi.",R.drawable.gif8),
            User("K","K harifi.",R.drawable.gif9),
            User("L","L harifi.",R.drawable.gif10),
            User("M","M harifi.",R.drawable.gif11),
            User("N","N harifi.",R.drawable.gif12),
            User("O","O harifi.",R.drawable.gif1),
            User("P","P harifi.",R.drawable.gif2),
            User("Q","Q harifi.",R.drawable.gif3),
            User("R","R harifi.",R.drawable.gif4),
            User("S","S harifi.",R.drawable.gif5),
            User("T","T harifi.",R.drawable.gif6),
            User("U","U harifi.",R.drawable.gif7),
            User("V","V harifi.",R.drawable.gif8),
            User("X","X harifi.",R.drawable.gif9),
            User("Y","Y harifi.",R.drawable.gif10),
            User("Z","Z harifi.",R.drawable.gif11),
            User("O'","O' harifi.",R.drawable.gif12),
            User("G'","G' harifi.",R.drawable.gif1),
            User("SH","SH harifi.",R.drawable.gif2),
            User("CH","CH harifi.",R.drawable.gif3),
            User("ng","ng harifi.",R.drawable.gif4),
            User("'","' tutiq belgisi.",R.drawable.gif5)
        ))

        rvAdabter=RvAdabter(list,object :onClick{
            override fun select(user: User, position: Int) {
                findNavController().navigate(R.id.selectFragment, bundleOf("key11" to list))
            }
        })

        val homeFragment=HomeFragment()
        val bundle=Bundle()
        bundle.putSerializable("keysearch",list)
        homeFragment.arguments=bundle

        rvAdabter.notifyDataSetChanged()
        binding.rv1.adapter=rvAdabter

        val itemCount=rvAdabter.itemCount

        if (itemCount > 0){
            binding.rv1.smoothScrollToPosition(itemCount-1)
        }
        binding.rv1.post {
            val layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,true).apply {
                reverseLayout=true
                stackFromEnd=true
            }
            binding.rv1.layoutManager=layoutManager
            var isButtonVisible = true
            binding.rv1.addOnScrollListener(object :RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState==RecyclerView.SCROLL_STATE_IDLE){
                        val lastVisibleItemPosition=layoutManager.findLastVisibleItemPosition()
                        val totalItemCount=layoutManager.itemCount
                        val threshold = 4
                        if(threshold + lastVisibleItemPosition >= totalItemCount ){
                        if (!isButtonVisible) {
                            isButtonVisible = true
                            binding.btnAmaliy.visibility = View.VISIBLE
                            binding.btnUrganish.visibility = View.VISIBLE
                        }
                        }else{
                            if (isButtonVisible){
                                isButtonVisible=false
                                binding.btnAmaliy.visibility=View.GONE
                                binding.btnUrganish.visibility=View.GONE
                            }
                        }
                    }
                }
            })
        }

    }
}