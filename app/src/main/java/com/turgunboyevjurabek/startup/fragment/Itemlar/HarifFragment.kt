package com.turgunboyevjurabek.startup.fragment.Itemlar

import User
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.adapters.onClick
import com.turgunboyevjurabek.startup.databinding.FragmentHarifBinding
class HarifFragment : Fragment() {
    private val binding by lazy { FragmentHarifBinding.inflate(layoutInflater) }
    private lateinit var rvAdabter: RvAdabter
    private lateinit var dataBase: DataBase
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
        dataBase=DataBase(requireContext())

        rvAdabter=RvAdabter(dataBase.getitemSelect(1),object :onClick{
            override fun select(user: User, position: Int) {
                findNavController().navigate(R.id.selectFragment, bundleOf("key11" to list,"keyP" to position ))
            }
        })

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