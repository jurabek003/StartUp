package com.turgunboyevjurabek.startup.fragment

import User
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.adapters.RvAdapterMain
import com.turgunboyevjurabek.startup.databinding.DilaogBottomsheetBinding
import com.turgunboyevjurabek.startup.databinding.DilogSheetBinding
import com.turgunboyevjurabek.startup.databinding.FragmentHomeBinding
import com.turgunboyevjurabek.startup.madels.MyObeject
import com.turgunboyevjurabek.startup.madels.User2
import java.lang.NullPointerException

class HomeFragment : Fragment() {
    private lateinit var dataBase: DataBase
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private lateinit var list: ArrayList<User2>
    private lateinit var rvAdapterMain: RvAdapterMain
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding.apply {

        }
        data()
        forBtnNavigation()
        return binding.root
    }

    private fun data(){
        binding.floating.setOnClickListener {
            val dialog= BottomSheetDialog(requireContext())
            val dialogSheetBinding=DilogSheetBinding.inflate(layoutInflater)
            dialog.setContentView(dialogSheetBinding.root)
         dialog.show()
            dialogSheetBinding.btnSave.setOnClickListener {
            val user2=User2(dialogSheetBinding.edtName.text.toString())
                list=ArrayList()
                list.add(user2)
                rvAdapterMain=RvAdapterMain(list)
                rvAdapterMain.notifyDataSetChanged()
                binding.rvMain.adapter=rvAdapterMain
                dialog.cancel()
            }
        }
    }

    private fun forBtnNavigation() {
        binding.btnNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.btn_search->{
                        findNavController().navigate(R.id.searchFragment)
                }
                R.id.btn_home->{
                    findNavController().navigate(R.id.homeFragment)
                    findNavController().popBackStack()

                }
                R.id.btn_medal->{
                    findNavController().navigate(R.id.cupFragment)

                }

            }
            true
        }
    }

}