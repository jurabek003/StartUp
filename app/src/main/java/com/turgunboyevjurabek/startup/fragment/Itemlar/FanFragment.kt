package com.turgunboyevjurabek.startup.fragment.Itemlar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.adapters.onClick
import com.turgunboyevjurabek.startup.databinding.FragmentFanBinding
import com.turgunboyevjurabek.startup.madels.User

class FanFragment : Fragment() {
private val binding by lazy { FragmentFanBinding.inflate(layoutInflater) }
    private lateinit var rvAdabter: RvAdabter
    private lateinit var list: ArrayList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding.btnUrganish.setOnClickListener {
            findNavController().navigate(R.id.selectFragment, bundleOf("key11" to list))
        }
        binding.btnAmaliy.setOnClickListener {
            findNavController().navigate(R.id.gameFragment, bundleOf("key12" to list))
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list= ArrayList()
        list.addAll(listOf(
            User("Matematika","qo'shish ko'paytrih va hokazolar",R.drawable.gif1),
            User("Bialogiya","O'simliklarn hayvonalar sungab o'hshash narsalarni o'rganadi",R.drawable.gif2),
            User("Ona tili ","yozish chizishni orgatadi",R.drawable.gif3),
            User("Fizika","hayot haqidagi fandir🧑‍🔬👨‍🔬",R.drawable.gif4),
            User("Tarih","O'tmishni o'rganadi",R.drawable.gif5),
            User("Matematika 2","qo'shish ko'paytrih va hokazolar",R.drawable.gif6),
            User("Bialogiya 2","O'simliklarn hayvonalar sungab o'hshash narsalarni o'rganadi",R.drawable.gif7),
            User("Ona tili 2","yozish chizishni orgatadi",R.drawable.gif8),
            User("Fizika 2" ,"hayot haqidagi fandir🧑‍🔬👨‍🔬",R.drawable.gif9),  User("Matematika","qo'shish ko'paytrih va hokazolar",R.drawable.gif1),
            User("Bialogiya","O'simliklarn hayvonalar sungab o'hshash narsalarni o'rganadi",R.drawable.gif2),
            User("Ona tili ","yozish chizishni orgatadi",R.drawable.gif3),
            User("Fizika","hayot haqidagi fandir🧑‍🔬👨‍🔬",R.drawable.gif4),
            User("Tarih","O'tmishni o'rganadi",R.drawable.gif5),
            User("Matematika 2","qo'shish ko'paytrih va hokazolar",R.drawable.gif6),
            User("Bialogiya 2","O'simliklarn hayvonalar sungab o'hshash narsalarni o'rganadi",R.drawable.gif7),
            User("Ona tili 2","yozish chizishni orgatadi",R.drawable.gif8),
            User("Fizika 2" ,"hayot haqidagi fandir🧑‍🔬👨‍🔬",R.drawable.gif9),
            User("Tarih 2","O'tmishni o'rganadi",R.drawable.gif10)))
        rvAdabter= RvAdabter(list,object :onClick{
            override fun select(user: User, position: Int) {
                findNavController().navigate(R.id.selectFragment, bundleOf("key11" to list))
            }
        })

        rvAdabter.notifyDataSetChanged()
binding.rv3.adapter=rvAdabter

        val itemCount=rvAdabter.itemCount
        if (itemCount>0){
            binding.rv3.smoothScrollToPosition(itemCount-1)
        }

        binding.rv3.post {
            val layoutManagaer=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,true).apply {
                reverseLayout=true
                stackFromEnd=true
            }
            binding.rv3.layoutManager=layoutManagaer

            var isVisibleButton=true

            binding.rv3.addOnScrollListener(object :RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE){
                        val findlastVisiblePosition=layoutManagaer.findLastVisibleItemPosition()
                        val findfirstVisiblePosition=layoutManagaer.findFirstVisibleItemPosition()

                        val totalItemPosition=layoutManagaer.itemCount
                        val threshold = 1
                        if (findlastVisiblePosition + threshold>= totalItemPosition){
                            if (!isVisibleButton){
                                isVisibleButton=true
                                binding.btnUrganish.visibility=View.VISIBLE
                                binding.btnAmaliy.visibility=View.VISIBLE
                            }
                        }else{
                            if (isVisibleButton){
                                isVisibleButton=false
                                binding.btnUrganish.visibility=View.GONE
                                binding.btnAmaliy.visibility=View.GONE
                            }
                        }

                    }
                }
            })
        }

    }
}