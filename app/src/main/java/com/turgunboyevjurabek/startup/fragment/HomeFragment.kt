package com.turgunboyevjurabek.startup.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.databinding.FragmentHomeBinding
import com.turgunboyevjurabek.startup.madels.User

class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding.apply {

        cardHarf.setOnClickListener {
            findNavController().navigate(R.id.harifFragment)
        }
        cardMedik.setOnClickListener {
            findNavController().navigate(R.id.meditFragment)
        }
        cardFan.setOnClickListener {
            findNavController().navigate(R.id.fanFragment)
        }

        }

        val listHarf=arguments?.getSerializable("keysearch") as ArrayList<User>
        Toast.makeText(requireContext(), "$listHarf", Toast.LENGTH_SHORT).show()

        forBtnNavigation()
        return binding.root
    }

    private fun forBtnNavigation() {
        binding.btnNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.btn_search->{
                    findNavController().navigate(R.id.searchFragment)
                }
            }
            true
        }
    }


}