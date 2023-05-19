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
import com.turgunboyevjurabek.startup.databinding.FragmentMeditBinding
import com.turgunboyevjurabek.startup.madels.MyObeject
import com.turgunboyevjurabek.startup.madels.User

class MeditFragment : Fragment() {
    private val binding by lazy { FragmentMeditBinding.inflate(layoutInflater) }
    private lateinit var rvAdabter: RvAdabter
    private lateinit var list2: ArrayList<User>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding.btnAmaliy.setOnClickListener {
            findNavController().navigate(R.id.gameFragment, bundleOf("key12" to list2))
        }

        binding.btnUrganish.setOnClickListener {
            findNavController().navigate(R.id.selectFragment, bundleOf("key11" to list2))
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list2= ArrayList()
        list2.addAll(listOf(User("shipris","davolash uchun",R.drawable.gif1),
            User("maska","davolash uchun",R.drawable.gif3),
            User("halat","davolash uchun",R.drawable.gif4),
            User("dorilar","davolash uchun",R.drawable.gif5),
            User("spirt","davolash uchun",R.drawable.gif6),
            User("tez yordam","davolash uchun",R.drawable.gif7),
            User("virach","davolash uchun",R.drawable.gif8),
            User("nevropotolog","davolash uchun",R.drawable.gif9),
            User("medik","davolash uchun",R.drawable.gif10),
            User("aperatsiya","davolash uchun",R.drawable.gif11),
            User("shipris","davolash uchun",R.drawable.gif2),
            User("maska","davolash uchun",R.drawable.gif3),
            User("halat","davolash uchun",R.drawable.gif4),
            User("dorilar","davolash uchun",R.drawable.gif5),
            User("spirt","davolash uchun",R.drawable.gif6),
            User("tez yordam","davolash uchun",R.drawable.gif7),
            User("virach","davolash uchun",R.drawable.gif8),
            User("nevropotolog","davolash uchun",R.drawable.gif9),
            User("medik","davolash uchun",R.drawable.gif10),
            User("aperatsiya","davolash uchun",R.drawable.gif12)
        ))

        rvAdabter= RvAdabter(list2,object :onClick{
            override fun select(user: User, position: Int) {
                findNavController().navigate(R.id.selectFragment, bundleOf("key11" to list2))
            } })
        rvAdabter.notifyDataSetChanged()
        binding.rv2.adapter=rvAdabter

        val itemCount = rvAdabter.itemCount
        if (itemCount > 0) {
            binding.rv2.smoothScrollToPosition(itemCount - 1)
        }


        binding.rv2.post {

            val layoutManager   = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,true).apply {
                reverseLayout = true
                stackFromEnd = true
            }

            binding.rv2.layoutManager=layoutManager

            // agar resakleView pastga scrol bulsa button ko'rinmay qolishi
            var isButtonVisible = true
            binding.rv2.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                        val totalItemCount = layoutManager.itemCount
                        val threshold = 1
                        if (lastVisibleItemPosition + threshold >= totalItemCount) {
                            if (!isButtonVisible) {
                                isButtonVisible = true
                                binding.btnAmaliy.visibility = View.VISIBLE
                                binding.btnUrganish.visibility = View.VISIBLE
                            }
                        } else {
                            if (isButtonVisible) {
                                isButtonVisible = false
                                binding.btnAmaliy.visibility = View.GONE
                                binding.btnUrganish.visibility = View.GONE
                            }
                        }
                    }
                }
            })
        }

    }
}