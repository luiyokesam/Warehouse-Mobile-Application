package com.example.warehousemobileapplication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.warehousemobileapplication.ui.stockin.StockIn
import com.example.warehousemobileapplication.ui.stockin.StockInViewModel
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.fragment_stock_in_details.*
import kotlinx.android.synthetic.main.fragment_stock_in_details.view.*
import java.lang.Integer.parseInt

class StockInDetailsFragment : Fragment() {
    private  lateinit var mStockInViewModel: StockInViewModel
    private var count:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //save inflated view to fragmentBinding
        val view = inflater.inflate(R.layout.fragment_stock_in_details, container, false)
        mStockInViewModel = ViewModelProvider(this).get(StockInViewModel::class.java)

        view.btn_stockin_add.setOnClickListener {
            insertDataToDatabase()
        }

        return  view
    }

    private fun addQuantity(){
        count++
        txt_stockin_quantity.setText(" " + count)
    }

    private fun minusQuantity(){
        if(count > 1){
            count--
            txt_stockin_quantity.setText(" " + count)
        }
    }

    private fun insertDataToDatabase() {
        val barcode = txt_stockin_code.text.toString()
//        val inquantity = parseInt(txt_stockin_quantity.text.toString())
        val inquantity = txt_stockin_quantity.text
        val indate = txt_stockin_date.text.toString()
//        val productType = txt_addproduct_ptype.text.toString()
//        val productPrice = txt_addproduct_pprice.text.toString()

        if (inputCheck(barcode,inquantity,indate)){
            val stockin = StockIn(0, barcode, inquantity, indate)
            mStockInViewModel.addStockIn(stockin)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_stockInDetailsFragment_to_stockInFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill in all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(barcode: String, inquantity: String, indate: String): Boolean{
        return !(TextUtils.isEmpty(barcode) && TextUtils.isEmpty(inquantity) && TextUtils.isEmpty(indate))
    }

    lateinit var btnBarcode: ImageButton
    lateinit var txtBarcode: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBarcode = view.findViewById(R.id.btn_stockin_scan)
        txtBarcode = view.findViewById(R.id.txt_stockin_code)


        btnBarcode.setOnClickListener {
            val intentIntegrator = IntentIntegrator.forSupportFragment(this)
            intentIntegrator.setBeepEnabled(false)
            intentIntegrator.setCameraId(0)
            intentIntegrator.setPrompt("SCAN")
            intentIntegrator.setBarcodeImageEnabled(false)
            intentIntegrator.initiateScan()
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(context, "Canceled", Toast.LENGTH_SHORT).show()
            } else {
                Log.d("Fragment", "Scanned from Fragment")
                Toast.makeText(context, "Scanned -> " + result.contents, Toast.LENGTH_SHORT)
                    .show()

                txtBarcode.text = result.contents

                Log.d("Fragment", "$result")
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}