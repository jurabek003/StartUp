package com.turgunboyevjurabek.startup.fragment.Itemlar

import User
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.turgunboyevjurabek.startup.DataBase.DataBase
import com.turgunboyevjurabek.startup.R
import com.turgunboyevjurabek.startup.adapters.RvAdabter
import com.turgunboyevjurabek.startup.adapters.onClick
import com.turgunboyevjurabek.startup.databinding.DialogMaterialBinding
import com.turgunboyevjurabek.startup.databinding.FragmentFanBinding
import com.turgunboyevjurabek.startup.madels.MyObeject
import java.io.File
import java.io.FileOutputStream
import java.net.IDN
import java.text.SimpleDateFormat
import java.util.Date

class FanFragment : Fragment(),onClick {
    private val binding by lazy { FragmentFanBinding.inflate(layoutInflater) }
    private lateinit var rvAdabter: RvAdabter
    private lateinit var list: ArrayList<User>
    private lateinit var dataBase: DataBase
    var ID:Int?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding.btnUrganish.setOnClickListener {
            findNavController().navigate(R.id.selectFragment, bundleOf("key11" to list))
        }

        binding.btnAmaliy.setOnClickListener {
            findNavController().navigate(R.id.gameFragment, bundleOf("key12" to list))
        }


        binding.addItem.setOnClickListener {
            findNavController().navigate(R.id.harifFragment, bundleOf("keyID2" to ID))
        }


        dataBase=DataBase(requireContext())
        Toast.makeText(requireContext(), "${MyObeject.nomi}", Toast.LENGTH_SHORT).show()
        Toast.makeText(requireContext(), "${MyObeject.number}", Toast.LENGTH_SHORT).show()
        if(!dataBase.getitemSelect(MyObeject.number).isNullOrEmpty()){
            rvAdabter= RvAdabter(dataBase.getitemSelect(MyObeject.number),this)
            binding.rv3.adapter=rvAdabter
            rvAdabter.notifyDataSetChanged()
        }
        Toast.makeText(requireContext(), "${dataBase.gameSelectItem(MyObeject.number!!)}", Toast.LENGTH_LONG).show()

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val itemCount = rvAdabter.itemCount
//            if (itemCount > 0) {
//                binding.rv3.smoothScrollToPosition(itemCount - 1)
//            }


      /*  binding.rv3.post{
            val layoutManagaer =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true).apply {
                    reverseLayout = true
                    stackFromEnd = true
                }
            binding.rv3.layoutManager = layoutManagaer

            var isVisibleButton = true

            binding.rv3.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val findlastVisiblePosition = layoutManagaer.findLastVisibleItemPosition()
                        val findfirstVisiblePosition = layoutManagaer.findFirstVisibleItemPosition()

                        val totalItemPosition = layoutManagaer.itemCount
                        val threshold = 1
                        if (findlastVisiblePosition + threshold >= totalItemPosition) {
                            if (!isVisibleButton) {
                                isVisibleButton = true
                                binding.btnUrganish.visibility = View.VISIBLE
                                binding.btnAmaliy.visibility = View.VISIBLE
                            }
                        } else {
                            if (isVisibleButton) {
                                isVisibleButton = false
                                binding.btnUrganish.visibility = View.GONE
                                binding.btnAmaliy.visibility = View.GONE
                            }
                        }

                    }
                }
            })
        }
       */
    }
    var pathIMage=""
    private val getImageContent=registerForActivityResult(ActivityResultContracts.GetContent()){
        it?:return@registerForActivityResult
        val dialogMaterialBinding=DialogMaterialBinding.inflate(layoutInflater)
        dialogMaterialBinding.selectGif.setImageURI(it)
        Toast.makeText(requireContext(), "Uraaaaaaaa", Toast.LENGTH_SHORT).show()

        val inputStrim=requireContext().contentResolver.openInputStream(it)
        val name = SimpleDateFormat("yyyyMMdd_hh_mm_ss").format(Date())
        val file= File(requireContext().filesDir, "$name.jpg")
        val fileOutputStream = FileOutputStream(file)
        inputStrim?.copyTo(fileOutputStream)
        inputStrim?.close()
        fileOutputStream.close()
        pathIMage = file.absolutePath
        Toast.makeText(requireContext(), "$pathIMage", Toast.LENGTH_SHORT).show()

    }

    override fun select(user: User, position: Int) {
        Toast.makeText(requireContext(), "${user.nomi}", Toast.LENGTH_SHORT).show()
        Toast.makeText(requireContext(), "${user.description}", Toast.LENGTH_SHORT).show()
    }

}

