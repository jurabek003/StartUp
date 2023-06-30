package com.turgunboyevjurabek.startup.fragment

import User
import android.graphics.drawable.Drawable
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
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdapterTArih
import com.turgunboyevjurabek.startup.databinding.DilaogBottomsheetBinding
import com.turgunboyevjurabek.startup.databinding.FragmentCupBinding
import com.turgunboyevjurabek.startup.madels.GameUser
import com.turgunboyevjurabek.startup.madels.MyObeject
import java.text.SimpleDateFormat
import java.util.Date

class CupFragment : Fragment() {
    private lateinit var dataBase: DataBase
    private val binding by lazy { FragmentCupBinding.inflate(layoutInflater) }
    private lateinit var rvAdapterTArih: RvAdapterTArih
    private lateinit var list: ArrayList<User>
    private lateinit var listGame1:ArrayList<User>
    private lateinit var listGame2:ArrayList<User>
    private lateinit var listGame3:ArrayList<User>
    private lateinit var listGame4:ArrayList<User>
    private lateinit var listcup:ArrayList<User>
    private lateinit var listcup2:ArrayList<User>
    private lateinit var listcup3:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBase=DataBase(requireContext())
        list=ArrayList()
        listGame1=ArrayList()
        listGame2=ArrayList()
        listGame3=ArrayList()
        listGame4=ArrayList()

        cardClick()


        kubok()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }
    private fun cardClick() {
        binding.conslayaout1.setOnClickListener {
            listGame1.clear()
            listGame1.addAll(dataBase.gameSelectItem(1))
            val dialog=BottomSheetDialog(requireContext())
            val dialogBottom=DilaogBottomsheetBinding.inflate(layoutInflater)
                rvAdapterTArih=RvAdapterTArih(listGame1)
                dialogBottom.rvTarih.adapter = rvAdapterTArih
                rvAdapterTArih.notifyDataSetChanged()
            dialog.setContentView(dialogBottom.root)
            list.clear()
            list.addAll(dataBase.getitemSelect(1))
            dialogBottom.itemName.setText(binding.textItem.text.toString())
            dialogBottom.btnCancal.setOnClickListener {
                dialog.cancel()
            }

            dialogBottom.btnStart.setOnClickListener {
                findNavController().navigate(R.id.gameCupFragment, bundleOf("keysItem" to list,"keyName" to binding.textItem.text,"keyNumber" to 1 ) )
                dialog.cancel()
            }
            dialog.show()
        }
        binding.conslayaout2.setOnClickListener {
            listGame2.clear()
            listGame2.addAll(dataBase.gameSelectItem(2))
            val dialog=BottomSheetDialog(requireContext())
            val dialogBottom=DilaogBottomsheetBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBottom.root)
            list.clear()
            list.addAll(dataBase.getitemSelect(2))
            dialogBottom.itemName.setText(binding.textItem3.text.toString())
                rvAdapterTArih=RvAdapterTArih(listGame2)
                dialogBottom.rvTarih.adapter=rvAdapterTArih
                rvAdapterTArih.notifyDataSetChanged()

            dialogBottom.btnCancal.setOnClickListener {
                dialog.cancel()
            }
            dialogBottom.btnStart.setOnClickListener {
                findNavController().navigate(R.id.gameCupFragment,bundleOf("keysItem" to list,"keyName" to binding.textItem3.text,"keyNumber" to 2))
                dialog.cancel()
            }
            dialog.show()
        }
        binding.conslayaout3.setOnClickListener {
            listGame3.clear()
            listGame3.addAll(dataBase.gameSelectItem(3))
            val dialog=BottomSheetDialog(requireContext())
            val dialogBottom=DilaogBottomsheetBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBottom.root)
            list.clear()
            list.addAll(dataBase.getitemSelect(3))
            dialogBottom.itemName.setText(binding.textItem4.text.toString())

                rvAdapterTArih=RvAdapterTArih(listGame3)
                dialogBottom.rvTarih.adapter=rvAdapterTArih
                rvAdapterTArih.notifyDataSetChanged()
            dialogBottom.btnCancal.setOnClickListener {
                dialog.cancel()
            }
            dialogBottom.btnStart.setOnClickListener {
                findNavController().navigate(R.id.gameCupFragment,bundleOf("keysItem" to list,"keyName" to binding.textItem4.text,"keyNumber" to 3))
                dialog.cancel()
            }
            dialogBottom.testSize.setText(list.size.toString())
            dialog.show()
        }
    }

    private fun kubok(){
        // harif fragment uchun
        var chanege1:Int=0
        listcup= ArrayList()
        listcup.addAll(dataBase.gameSelectItem(1))
        val time=SimpleDateFormat("dd:MM:yyyy").format(Date())
        for (i in 0 until listcup.size){
            if (listcup[i].gameMemory.contains(time)) chanege1++
        }
        if(chanege1 >=0 && chanege1 < 3){
            binding.imageCup1.setImageResource(R.drawable.cup3th)
        }else if(chanege1 >=3 && chanege1<6){
            binding.imageCup1.setImageResource(R.drawable.cup2th)
        }else if(chanege1>=6 && chanege1<9){
            binding.imageCup1.setImageResource(R.drawable.cup1th)
        }else if (chanege1>=10){
            binding.imageCup1.setImageResource(R.drawable.cup1th)
        }

    // medik fragment uchun
    var chanege2:Int=0
    listcup2= ArrayList()
    listcup2.addAll(dataBase.gameSelectItem(2))
        val time2=SimpleDateFormat("dd:MM:yyyy").format(Date())
    for (i in 0 until listcup2.size){
        if (listcup2[i].gameMemory.contains(time2) ) chanege2++
    }
        if(chanege2 >=0 && chanege2 < 3){
            binding.imageCup2.setImageResource(R.drawable.cup3th)
        }else if(chanege2 >=3 && chanege2<6){
            binding.imageCup2.setImageResource(R.drawable.cup2th)
        }else if(chanege2>=6 && chanege2<9){
            binding.imageCup2.setImageResource(R.drawable.cup1th)
        }else if (chanege2>=10){
            binding.imageCup2.setImageResource(R.drawable.cup1th)
        }

        // fan fragment uchun
        var chanege3:Int=0
        listcup3=ArrayList()
        val time3=SimpleDateFormat("dd:MM:yyyy").format(Date())
        Toast.makeText(requireContext(), "$time3", Toast.LENGTH_SHORT).show()
        listcup3.addAll(dataBase.gameSelectItem(3))
        for (i in 0 until listcup3.size){
            if (listcup3[i].gameMemory.contains(time3)) chanege3++
        }
        if(chanege3 >=0 && chanege3 < 3){
            binding.imageCup3.setImageResource(R.drawable.cup3th)
        }else if(chanege3 >=3 && chanege3<6){
            binding.imageCup3.setImageResource(R.drawable.cup2th)
        }else if(chanege3>=6 && chanege3<9){
            binding.imageCup3.setImageResource(R.drawable.cup1th)
        }else if (chanege3>=10){
            binding.imageCup3.setImageResource(R.drawable.cup1th)
        }
    }
}