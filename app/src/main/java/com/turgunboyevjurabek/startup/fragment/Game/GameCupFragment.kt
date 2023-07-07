package com.turgunboyevjurabek.startup.fragment.Game

import User
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.databinding.FragmentGameCupBinding
import com.turgunboyevjurabek.startup.madels.GameUser
import com.turgunboyevjurabek.startup.madels.MyObeject
import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.abs
import kotlin.random.Random
import kotlin.random.nextInt

class GameCupFragment : Fragment() {
    private val binding by lazy { FragmentGameCupBinding.inflate(layoutInflater) }
    private lateinit var list:ArrayList<User>
    private lateinit var dataBase: DataBase
    private var game :Int=0
    private var gameNumber :Int?=null
    private var gameFalse :Int=0
    private var gameTrue :Int=0
    private var ItemName:String?=null
    private var a:Int?=null
    private var b:Int?=null
    private var c:Int?=null
    private var d:Int?=null
    private var f:Int?=null
    private var e:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            randomSon()
        }catch (e:StackOverflowError){
            list.clear()

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }
    @SuppressLint("ResourceAsColor", "SuspiciousIndentation", "SimpleDateFormat")
    private fun randomSon() {
        dataBase= DataBase(requireContext())
        list=ArrayList()
        list=arguments?.getSerializable("keysItem") as ArrayList<User>
        ItemName=arguments?.getString("keyName")
        gameNumber=arguments?.getInt("keyNumber")

        val size=list.size
        try {
            if (size>5){
                a = Random.nextInt(size)
                b = Random.nextInt(size)
                c = Random.nextInt(size)
                d = Random.nextInt(size)
                f = Random.nextInt(size)
                e= Random.nextInt(4)
            }

        }catch (ex:IllegalArgumentException){
            a = Random.nextInt(size)
            b = Random.nextInt(size)
            c = Random.nextInt(size)
            d = Random.nextInt(size)
            f = Random.nextInt(size)
            e=Random.nextInt(4)
            abs(a!!)
            abs(b!!)
            abs(d!!)
            abs(c!!)
            abs(f!!)
            abs(e!!)
        }
        try {
            if (d==f || b==c || c==d || a==b || a==c ||a == d ||a==f || f==b || f==c ){
                randomSon()
                return
            }
        }catch (e:StackOverflowError){
            Toast.makeText(requireContext(), "Server hatoligi", Toast.LENGTH_SHORT).show()
            
        }
        

        binding.gameGif.setImageURI(Uri.parse(list[a!!].gifImage.toString()))
        binding.btn1.setText(list[b!!].nomi)
        binding.btn2.setText(list[c!!].nomi)
        binding.btn3.setText(list[d!!].nomi)
        binding.btn4.setText(list[f!!].nomi)

        if (e==0){
            binding.btn1.setText(list[a!!].nomi)
        }else if (e==1){
            binding.btn2.setText(list[a!!].nomi)
        }else if (e==2){
            binding.btn3.setText(list[a!!].nomi)
        }else if (e==3){
            binding.btn4.setText(list[a!!].nomi)
        }

        binding.btn1.setOnClickListener {
            if(binding.btn1.text == list[a!!].nomi.toString()){
                game++
                gameTrue++
                binding.thtCount.text=game.toString()
                randomSon()
            }else{
//                val user=User(list[a!!].nomi,list[a!!].description,list[a!!].gifImage,list[a!!].nomeri)
//                findNavController().navigate(R.id.itemSearchFragment, bundleOf("k1" to user.nomi, "k2" to user.description, "k3" to user.gifImage))
                gameFalse++
            }
        }
        binding.btn2.setOnClickListener {
            if(binding.btn2.text == list[a!!].nomi.toString()){
                game++
                gameTrue++
                binding.thtCount.text=game.toString()
                randomSon()
            }else{
//                val user=User(list[a!!].nomi,list[a!!].description,list[a!!].gifImage,list[a!!].nomeri)
//                findNavController().navigate(R.id.itemSearchFragment, bundleOf("k1" to user.nomi, "k2" to user.description, "k3" to user.gifImage))
                gameFalse++
            }
        }
        binding.btn3.setOnClickListener {
            if(binding.btn3.text == list[a!!].nomi.toString()){
                game++
                gameTrue++
                binding.thtCount.text=game.toString()
                randomSon()
            }else{
//                val user=User(list[a!!].nomi,list[a!!].description,list[a!!].gifImage,list[a!!].nomeri)
//                findNavController().navigate(R.id.itemSearchFragment, bundleOf("k1" to user.nomi, "k2" to user.description, "k3" to user.gifImage))
                gameFalse++
            }
        }
        binding.btn4.setOnClickListener {
            if(binding.btn4.text == list[a!!].nomi.toString()){
                game++
                gameTrue++
                binding.thtCount.text=game.toString()
                randomSon()
            }else{
//                val user=User(list[a!!].nomi,list[a!!].description,list[a!!].gifImage,list[a!!].nomeri)
//                    findNavController().navigate(R.id.itemSearchFragment, bundleOf("k1" to user.nomi, "k2" to user.description, "k3" to user.gifImage))
                    gameFalse++
            }
        }

        if( binding.btn1.text==binding.btn2.text || binding.btn1.text==binding.btn3.text ||
            binding.btn1.text==binding.btn4.text || binding.btn2.text==binding.btn1.text ||
            binding.btn2.text==binding.btn3.text || binding.btn3.text==binding.btn1.text ||
            binding.btn3.text==binding.btn2.text || binding.btn3.text==binding.btn4.text ||
            binding.btn4.text==binding.btn1.text || binding.btn4.text==binding.btn2.text ||
            binding.btn4.text==binding.btn3.text){
            randomSon()
            return
        }
        binding.thtCount.setText(game.toString())
        if(game == list.size){
            val soat = SimpleDateFormat("dd:MM:yyyy_hh:mm:ss").format(Date())
            MyObeject.vaqt=soat
            val user=User("","","123",12 ,gameNumber,soat,gameTrue,gameFalse,ItemName)
            dataBase.insertItem(user)
            gameTrue=0
            gameFalse=0
            game=0

            val dialog=AlertDialog.Builder(requireContext())
                dialog.setMessage("siz berilgan savollarni barchasiga javop berip boldingiz")
                dialog.setTitle("Tabriklayman 🎉")
                dialog.setCancelable(false)
                dialog.setPositiveButton("Davom etish",object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        dialog?.cancel()
                        randomSon()
                    }
                })
            dialog.setNegativeButton("Chiqish",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    findNavController().navigate(R.id.cupFragment)
                }
            })

            dialog.show()
        }

    }

    override fun onStop() {
        super.onStop()
        val soat = SimpleDateFormat("dd:MM:yyyy_hh:mm:ss").format(Date())
        MyObeject.vaqt=soat
        val user=User("","","123",12 ,gameNumber,soat,gameTrue,gameFalse,ItemName)
        if (gameTrue!=0 && gameFalse!=0){
            dataBase.insertItem(user)
        }
    }
}