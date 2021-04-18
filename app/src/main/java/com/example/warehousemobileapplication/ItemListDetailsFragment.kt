package com.example.warehousemobileapplication

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.warehousemobileapplication.data.Product
import com.example.warehousemobileapplication.data.ProductViewModel
import kotlinx.android.synthetic.main.fragment_item_list_details.*
import kotlinx.android.synthetic.main.fragment_item_list_details.view.*

class ItemListDetailsFragment : Fragment() {
    private  lateinit var mProductViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //save inflated view to fragmentBinding
        val view = inflater.inflate(R.layout.fragment_item_list_details, container, false)
        mProductViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        view.btn_addproduct_add.setOnClickListener {
            insertDataToDatabase()
        }
        return  view
   }

    private fun insertDataToDatabase() {
        val barcode = txt_addproduct_barcode.text.toString()
        val productName = txt_addproduct_pname.text.toString()
        val companyName = txt_addproduct_cname.text.toString()
        val productType = txt_addproduct_ptype.text.toString()
        val productPrice = txt_addproduct_pprice.text.toString()

        if (inputCheck(barcode,productName,companyName,productType,productPrice)){

            val product = Product(0, barcode, productName, companyName, productType, productPrice)

            mProductViewModel.addProduct(product)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_itemListDetailsFragment_to_itemListFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out  all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(barcode: String, productName: String, companyName: String, productType: String, productPrice: String): Boolean{
        return !(TextUtils.isEmpty(barcode) && TextUtils.isEmpty(productName) && TextUtils.isEmpty(companyName) && TextUtils.isEmpty(productName) && TextUtils.isEmpty(productType) && TextUtils.isEmpty(productPrice))
    }
}