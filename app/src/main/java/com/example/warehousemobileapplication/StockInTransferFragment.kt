package com.example.warehousemobileapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.warehousemobileapplication.ui.stockin.StockIn
import com.example.warehousemobileapplication.ui.stockin.StockInViewModel
import com.example.warehousemobileapplication.ui.stocktransfer.StockTransferViewModel
import kotlinx.android.synthetic.main.fragment_stock_in_transfer.*
import kotlinx.android.synthetic.main.fragment_stock_in_transfer.view.*

class StockInTransferFragment : Fragment() {
//    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mStockTransferViewModel: StockTransferViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stock_in_transfer, container, false)

        mStockTransferViewModel = ViewModelProvider(this).get(StockTransferViewModel::class.java)

//        view.txt_stockin_transfer_rackid.setText(args.currentUser.firstName)
//        view.txt_stockin_transfer_barcode.setText(args.currentUser.barcode)
//        view.txt_stockin_transfer_quantity.setText(args.currentUser.age.toString())

        view.btn_stockin_transfer_transfer.setOnClickListener{
//            updateItem()
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }

//    private fun updateItem(){
//        val rackid = txt_stockin_transfer_rackid.text.toString()
//        val barcode = txt_stockin_transfer_barcode.text.toString()
//        val quantity =Integer.parseInt(txt_stockin_transfer_quantity.text.toString())
//
//        if(inputCheck(rackid, barcode, quantity)){
//            //Create User Object
//            val updatedUser = StockIn(args.currantStockIn.id, rackid, barcode, quantity)
//            //Update Current User
//            mUserViewModel.updateUser(updatedUser)
//            Toast.makeText(requireContext(), "Update Sucessfully", Toast.LENGTH_SHORT).show()
//            //Navigate Back
//            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
//        }else{
//            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
//        }
//    }
}