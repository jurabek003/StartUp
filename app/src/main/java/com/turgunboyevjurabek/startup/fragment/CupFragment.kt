package com.turgunboyevjurabek.startup.fragment

import User
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.DataBase.DataBase2
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.Click
import com.turgunboyevjurabek.startup.adapters.RvAdapterTArih
import com.turgunboyevjurabek.startup.adapters.RvGameMain
import com.turgunboyevjurabek.startup.databinding.DilaogBottomsheetBinding
import com.turgunboyevjurabek.startup.databinding.FragmentCupBinding
import com.turgunboyevjurabek.startup.madels.MyObeject
import com.turgunboyevjurabek.startup.madels.User2
import java.text.SimpleDateFormat
import java.util.Date

class CupFragment : Fragment(),Click {

    private lateinit var dataBase: DataBase
    private val binding by lazy { FragmentCupBinding.inflate(layoutInflater) }
    private lateinit var rvAdapterTArih: RvAdapterTArih
    private lateinit var rvGameMain: RvGameMain
    private lateinit var dataBase2: DataBase2
    private lateinit var list: ArrayList<User>
    lateinit var list2: ArrayList<User2>
    private lateinit var listGame1:ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyObeject.cup1=0
        MyObeject.cup2=0
        dataBase=DataBase(requireContext())
        dataBase2=DataBase2(requireContext())
        list=ArrayList()
        listGame1=ArrayList()
         list2=ArrayList()
        list2.addAll(dataBase2.getItems())
        rvGameMain=RvGameMain(requireContext(),list2,this)
        binding.rvGame.adapter=rvGameMain
        val listGame= ArrayList<User>()
        for(i in 0 until rvGameMain.list.size){
           listGame.addAll(dataBase.gameSelectItem(i+1))
            for (j in i  until list.size){
                list[i].gameTrue = list[i].gameTrue!! + listGame[j].gameTrue!!
            }
        }
        Toast.makeText(requireContext(), "${MyObeject.cup1}---${MyObeject.cup2}", Toast.LENGTH_SHORT).show()
      //  cubok()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

    return binding.root
    }
    override fun selectGame(position: Int,user2: User2) {
        MyObeject.cup1=0
        MyObeject.cup2=0
        val list=ArrayList<User>()
        val dataBase=DataBase(requireContext())
        list.addAll(dataBase.getitemSelect(position+1))
        val dialog=BottomSheetDialog(requireContext())
        val dilaogBottomsheetBinding=DilaogBottomsheetBinding.inflate(layoutInflater)
        dialog.setContentView(dilaogBottomsheetBinding.root)
        dilaogBottomsheetBinding.itemName.text=user2.ismi
        dialog.show()
        Toast.makeText(requireContext(), "${MyObeject.cup1 }---${MyObeject.cup2}", Toast.LENGTH_SHORT).show()
        dilaogBottomsheetBinding.btnStart.setOnClickListener {
            if(list.size>5){
                findNavController().navigate(R.id.gameCupFragment, bundleOf("keysItem" to list,"keyName" to user2.ismi,"keyNumber" to position+1 ))
                dialog.cancel()
                MyObeject.cup1=0
                MyObeject.cup2=0
            }else{
                Toast.makeText(requireContext(), "iltimos oldin itemlarni kiriting so'ngra qayta urinib ko'ring", Toast.LENGTH_LONG).show()
                dialog.cancel()
                MyObeject.cup1=0
                MyObeject.cup2=0
            }
}
        val listTarih=ArrayList<User>()
        if(!dataBase.gameSelectItem(position+1).isEmpty()){

            listTarih.addAll(dataBase.gameSelectItem(position+1))
            rvAdapterTArih=RvAdapterTArih(dataBase.gameSelectItem(position+1))
            dilaogBottomsheetBinding.rvTarih.adapter=rvAdapterTArih
            rvAdapterTArih.notifyDataSetChanged()
        }
    }
//    private fun cubok() {
//        val timeDay=SimpleDateFormat("dd:MM:yyyy").format(Date())
//        var count=0
//        var listTime2=ArrayList<Int>()
//        val listTime=ArrayList<User>()
//        for (i in 1 until list2.size+1){
//            listTime.addAll(dataBase.gameSelectItem(i))
//            for ( j in 0 until listTime.size){
//                if (listTime[j].gameMemory.contains(timeDay)){
//                   count++
//                }
//                if (j==listTime.size){
//                    listTime2[i]=count
//                    count=0
//                }
//            }
//        }
//        for (i in 1 until listTime2.size+1){
//                rvGameMain.list[i-1].cup = listTime2[i]
//        }
//    }

}