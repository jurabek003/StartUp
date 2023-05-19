package com.turgunboyevjurabek.startup.fragment.Game

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.databinding.FragmentFanBinding
import com.turgunboyevjurabek.startup.databinding.FragmentGameBinding
import com.turgunboyevjurabek.startup.madels.User
import kotlin.math.E
import kotlin.random.Random

class GameFragment : Fragment() {
    private val binding by lazy { FragmentGameBinding.inflate(layoutInflater) }
    private lateinit var list:ArrayList<User>
    private var i:Int=0
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        list=arguments?.getSerializable("key12") as ArrayList<User>

            randomSon()


        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    private fun randomSon() {

        val a=Random.nextInt(list.size)
        val b=Random.nextInt(list.size)
        val c=Random.nextInt(list.size)
        val d=Random.nextInt(list.size)
        val f=Random.nextInt(list.size)
        val e=Random.nextInt(4)

        if (d==f || b==c || c==d || a==b || a==c ||a == d ||a==f || f==b || f==c || f==a ){
            randomSon()
            return
        }
        //Toast.makeText(requireContext(), "a = $a; b = $b; c = $c; d = $d; f =  $f; e = $e ", Toast.LENGTH_SHORT).show()
        binding.gameGif.setImageResource(list[a].gifImage!!)
        binding.btn1.setText(list[b].nomi)
        binding.btn2.setText(list[c].nomi)
        binding.btn3.setText(list[d].nomi)
        binding.btn4.setText(list[f].nomi)
                if (e==0){
                    binding.btn1.setText(list[a].nomi)
                }else if (e==1){
                    binding.btn2.setText(list[a].nomi)
                }else if (e==2){
                    binding.btn3.setText(list[a].nomi)
                }else if (e==3){
                    binding.btn4.setText(list[a].nomi)
                }
        binding.btn1.setOnClickListener {
            if(binding.btn1.text == list[a].nomi.toString()){
                binding.btn1.setBackgroundColor(R.color.red)
                binding.btn1.setBackgroundColor(R.color.white)
                Toast.makeText(requireContext(), "To'g'ri 🎉", Toast.LENGTH_SHORT).show()
                randomSon()
            }
        }
        binding.btn2.setOnClickListener {
            if(binding.btn2.text == list[a].nomi.toString()){
                binding.btn2.setBackgroundColor(R.color.red)
                binding.btn2.setBackgroundColor(R.color.white)
                Toast.makeText(requireContext(), "To'g'ri 🎉", Toast.LENGTH_SHORT).show()
                randomSon()
            }
        }
        binding.btn3.setOnClickListener {
            if(binding.btn3.text == list[a].nomi.toString()){
                binding.btn3.setBackgroundColor(R.color.red)
                binding.btn3.setBackgroundColor(R.color.white)
                Toast.makeText(requireContext(), "To'g'ri 🎉", Toast.LENGTH_SHORT).show()
                randomSon()
            }
        }
        binding.btn4.setOnClickListener {
            if(binding.btn4.text == list[a].nomi.toString()){
                binding.btn4.setBackgroundColor(R.color.red)
                binding.btn4.setBackgroundColor(R.color.white)
                Toast.makeText(requireContext(), "To'g'ri 🎉", Toast.LENGTH_SHORT).show()
                randomSon()
            }
        }

        if(binding.btn1.text==binding.btn2.text || binding.btn1.text==binding.btn3.text ||
                    binding.btn1.text==binding.btn4.text || binding.btn2.text==binding.btn1.text ||
                    binding.btn2.text==binding.btn3.text ||binding.btn3.text==binding.btn1.text ||
                    binding.btn3.text==binding.btn2.text ||binding.btn3.text==binding.btn4.text ||
                    binding.btn4.text==binding.btn1.text ||binding.btn4.text==binding.btn2.text ||
                    binding.btn4.text==binding.btn3.text){
            randomSon()
            return
        }
    }
}