package com.turgunboyevjurabek.startup.fragment.Itemlar

import User
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.databinding.DialogMaterialBinding
import com.turgunboyevjurabek.startup.databinding.FragmentHarifBinding
import com.turgunboyevjurabek.startup.madels.MyObeject
import com.turgunboyevjurabek.startup.madels.MyObeject.description
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date

class HarifFragment : Fragment() {
    private val binding by lazy { FragmentHarifBinding.inflate(layoutInflater) }
    private lateinit var dataBase: DataBase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding.selectGif.setOnClickListener {
            getImageContent.launch("image/*")
    }
        dataBase= DataBase(requireContext())
        binding.btnAdd.setOnClickListener {
            if (!binding.edtNameItem.text.isNullOrEmpty() && !binding.edtDescriptionItem.text.isNullOrEmpty()){
               val  user=User(binding.edtNameItem.text.toString(),binding.edtDescriptionItem.text.toString(),
                    pathIMage,MyObeject.number,0,"",0,0,"")
                dataBase.insertItem(user)
                findNavController().popBackStack().not()
                findNavController().navigate(R.id.fanFragment)
            }
        }
        return binding.root
    }
    var pathIMage=""
    @SuppressLint("SimpleDateFormat")
    private val getImageContent=registerForActivityResult(ActivityResultContracts.GetContent()){
        it?:return@registerForActivityResult
        binding.selectGif.setImageURI(it)
        Toast.makeText(requireContext(), "Uraaaaaaaa", Toast.LENGTH_SHORT).show()

        val inputStrim=requireContext().contentResolver.openInputStream(it)
        val name = SimpleDateFormat("yyyyMMdd_hh_mm_ss").format(Date())
        val file= File(requireContext().filesDir, "$name.gif")
        val fileOutputStream = FileOutputStream(file)
        inputStrim?.copyTo(fileOutputStream)
        inputStrim?.close()
        fileOutputStream.close()
        Toast.makeText(requireContext(), pathIMage, Toast.LENGTH_SHORT).show()
        pathIMage = file.absolutePath
    }
}