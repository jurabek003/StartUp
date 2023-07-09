package com.turgunboyevjurabek.startup.fragment

import User
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.DataBase.DataBase2
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.adapters.RvAdapterMain
import com.turgunboyevjurabek.startup.adapters.SelectClick
import com.turgunboyevjurabek.startup.databinding.DilaogBottomsheetBinding
import com.turgunboyevjurabek.startup.databinding.DilogSheetBinding
import com.turgunboyevjurabek.startup.databinding.FragmentHomeBinding
import com.turgunboyevjurabek.startup.madels.MyObeject
import com.turgunboyevjurabek.startup.madels.User2
import java.lang.NullPointerException

class HomeFragment : Fragment(),SelectClick {
    private lateinit var dataBase: DataBase
    private lateinit var dataBase2: DataBase2
    var isChacced=true
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private lateinit var list: ArrayList<User2>
    private lateinit var rvAdapterMain: RvAdapterMain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBase2=DataBase2(requireContext())
        if (!dataBase2.getItems().equals(null)){
            rvAdapterMain=RvAdapterMain(dataBase2.getItems(),this)
            binding.rvMain.adapter=rvAdapterMain
        }
    }
    @RequiresApi(Build.VERSION_CODES.P)
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
        dataBase2=DataBase2(requireContext())
        binding.floating.setOnClickListener {
            val dialog= BottomSheetDialog(requireContext())
            val dialogSheetBinding=DilogSheetBinding.inflate(layoutInflater)
            dialog.setContentView(dialogSheetBinding.root)
         dialog.show()
            dialogSheetBinding.btnSave.setOnClickListener {
            val user2=User2(dialogSheetBinding.edtName.text.toString())
                list=ArrayList()
                dataBase2.insertItem(user2)
                list.addAll(dataBase2.getItems())
                rvAdapterMain=RvAdapterMain(list,this)
                rvAdapterMain.notifyDataSetChanged()
                binding.rvMain.adapter=rvAdapterMain
                dialog.cancel()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
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
                R.id.btn_settings->{
                    val popapMenu=PopupMenu(requireContext(),binding.btnNavigation)
                    popapMenu.inflate(R.menu.popap_menu)
                    popapMenu.show()
                    popapMenu.setOnMenuItemClickListener {
                        when(it.itemId){
                            R.id.theme_id->{
                                if (isChacced){
                                    isChacced=false
                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                                }else{
                                    isChacced=true
                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
                                }
                            }
                        }
                        true
                    }
                }
                R.id.exit_id->{
                }
            }
            true
        }
    }

    override fun selectclick(user2: User2, position: Int) {
        MyObeject.number=user2.id
        findNavController().navigate(R.id.fanFragment, bundleOf("keyID" to user2.id))
    }

}