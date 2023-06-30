package com.turgunboyevjurabek.startup.fragment

import User
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.databinding.FragmentHomeBinding
import com.turgunboyevjurabek.startup.madels.MyObeject
import java.lang.NullPointerException

class HomeFragment : Fragment() {
    private lateinit var dataBase: DataBase
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private lateinit var list1: ArrayList<User>
    private lateinit var list2: ArrayList<User>
    private lateinit var list3: ArrayList<User>
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

        dataBasefunktion()

        forBtnNavigation()
        return binding.root
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

    private fun dataBasefunktion() {
        dataBase= DataBase(binding.root.context)

        // harif fragmentning bazasiga list yuklash
        list1= ArrayList()
        list1.addAll(listOf(
            User("A","A harifi.",R.drawable.mygif,1,100,"",1,1,"harif"),
            User("B","B harifi.",R.drawable.gif1,1,1000,"",1,1,"harif"),
            User("D","D harifi.",R.drawable.gif2,1,100,"",1,1,"harif"),
            User("E","E harifi.",R.drawable.gif3,1,100,"",1,1,"harif"),
            User("F","F harifi.",R.drawable.gif4,1,100,"",1,1,"harif"),
            User("G","G harifi.",R.drawable.gif5,1,100,"",1,1,"harif"),
            User("H","H harifi.",R.drawable.gif6,1,100,"",1,1,"harif"),
            User("I","I harifi.",R.drawable.gif7,1,100,"",1,1,"harif"),
            User("J","J harifi.",R.drawable.gif8,1,100,"",1,1,"harif"),
            User("K","K harifi.",R.drawable.gif9,1,100,"",1,1,"harif"),
            User("L","L harifi.",R.drawable.gif10,1,100,"",1,1,"harif"),
            User("M","M harifi.",R.drawable.gif11,1,100,"",1,1,"harif"),
            User("N","N harifi.",R.drawable.gif12,1,100,"",1,1,"harif"),
            User("O","O harifi.",R.drawable.gif1,1,100,"",1,1,"harif"),
            User("P","P harifi.",R.drawable.gif2,1,100,"",1,1,"harif"),
            User("Q","Q harifi.",R.drawable.gif3,1,100,"",1,1,"harif"),
            User("R","R harifi.",R.drawable.gif4,1,100,"",1,1,"harif"),
            User("S","S harifi.",R.drawable.gif5,1,100,"",1,1,"harif"),
            User("T","T harifi.",R.drawable.gif6,1,100,"",1,1,"harif"),
            User("U","U harifi.",R.drawable.gif7,1,100,"",1,1,"harif"),
            User("V","V harifi.",R.drawable.gif8,1,100,"",1,1,"harif"),
            User("X","X harifi.",R.drawable.gif9,1,100,"",1,1,"harif"),
            User("Y","Y harifi.",R.drawable.gif10,1,100,"",1,1,"harif"),
            User("Z","Z harifi.",R.drawable.gif11,1,100,"",1,1,"harif"),
            User("O'","O' harifi.",R.drawable.gif12,1,100,"",1,1,"harif"),
            User("G'","G' harifi.",R.drawable.gif1,1,100,"",1,1,"harif"),
            User("SH","SH harifi.",R.drawable.gif2,1,100,"",1,1,"harif"),
            User("CH","CH harifi.",R.drawable.gif3,1,100,"",1,1,"harif"),
            User("ng","ng harifi.",R.drawable.gif4,1,100,"",1,1,"harif"),
            User("'","' tutiq belgisi.",R.drawable.gif5,1,100,"",1,1,"harif")))

        var user=User()

        for (i in 0 until  list1.size){
            val choosItem= dataBase.getItems().find { it.nomi==list1[i].nomi }
            if (choosItem == null){
                user=list1[i]
                dataBase.insertItem(user)
            }
        }
        // medik fragmentning bazasiga list yuklash
        list2= ArrayList()
        list2.addAll(listOf(User("shipris","davolash uchun",R.drawable.gif1,2,100,"",2,2,"medik"),
            User("maska","davolash uchun",R.drawable.gif3,2,100,"",2,2,"medik"),
            User("halat","davolash uchun",R.drawable.gif4,2,100,"",2,2,"medik"),
            User("dorilar","davolash uchun",R.drawable.gif5,2,100,"",2,2,"medik"),
            User("spirt","davolash uchun",R.drawable.gif6,2,100,"",2,2,"medik"),
            User("tez yordam","davolash uchun",R.drawable.gif7,2,100,"",2,2,"medik"),
            User("virach","davolash uchun",R.drawable.gif8,2,100,"",2,2,"medik"),
            User("nevropotolog","davolash uchun",R.drawable.gif9,2,100,"",2,2,"medik"),
            User("medik","davolash uchun",R.drawable.gif10,2,100,"",2,2,"medik"),
            User("aperatsiya","davolash uchun",R.drawable.gif11,2,100,"",2,2,"medik"),
            User("shipris","davolash uchun",R.drawable.gif2,2,100,"",2,2,"medik"),
            User("maska","davolash uchun",R.drawable.gif3,2,100,"",2,2,"medik"),
            User("halat","davolash uchun",R.drawable.gif4,2,100,"",2,2,"medik"),
            User("dorilar","davolash uchun",R.drawable.gif5,2,100,"",2,2,"medik"),
            User("spirt","davolash uchun",R.drawable.gif6,2,100,"",2,2,"medik"),
            User("tez yordam","davolash uchun",R.drawable.gif7,2,100,"",2,2,"medik"),
            User("virach","davolash uchun",R.drawable.gif8,2,100,"",2,2,"medik"),
            User("nevropotolog","davolash uchun",R.drawable.gif9,2,100,"",2,2,"medik"),
            User("medik","davolash uchun",R.drawable.gif10,2,100,"",2,2,"medik"),
            User("aperatsiya","davolash uchun",R.drawable.gif1,2,100,"",2,2,"medik")
        ))

        var user2=User()

        for (i in 0 until  list2.size){
            val choosItem= dataBase.getItems().find { it.nomi==list2[i].nomi }
            if (choosItem==null){
                user2=list2[i]
                dataBase.insertItem(user2)
            }
        }
        // fan fragmnetning bazasiga list yuklash
        list3 = ArrayList()
        list3.addAll(
            listOf(
                User("Bialogiya", "O'simliklarn hayvonalar sungab o'hshash narsalarni o'rganadi", R.drawable.gif2,3,100,"",3,3,"fan"),
                User("Ona tili ", "yozish chizishni orgatadi", R.drawable.gif3,3,100,"",3,3,"fan"),
                User("Fizika", "hayot haqidagi fandir🧑‍🔬👨‍🔬", R.drawable.gif4,3,100,"",3,3,"fan"),
                User("Tarih", "O'tmishni o'rganadi", R.drawable.gif5,3),
                User("Matematika 2", "qo'shish ko'paytrih va hokazolar", R.drawable.gif6,3,100,"",3,3,"fan"),
                User("Bialogiya 2", "O'simliklarn hayvonalar sungab o'hshash narsalarni o'rganadi", R.drawable.gif7,3,100,"",3,3,"fan"),
                User("Ona tili 2", "yozish chizishni orgatadi", R.drawable.gif8,3,100,"",3,3,"fan"),
                User("Fizika 2", "hayot haqidagi fandir🧑‍🔬👨‍🔬", R.drawable.gif9,3,100,"",3,3,"fan"),
                User("Tarih 2", "O'tmishni o'rganadi", R.drawable.gif1,3,100,"",3,3,"fan"),
                User("Matematika", "qo'shish ko'paytrih va hokazolar", R.drawable.gif1,3,100,"",3,3,"fan")
            ))

        var user3=User()

        for (i in 0 until  list3.size){
            val choosItem= dataBase.getItems().find { it.nomi==list3[i].nomi }
            if (choosItem==null){
                user3=list3[i]
                dataBase.insertItem(user3)
            }
        }

    }
}