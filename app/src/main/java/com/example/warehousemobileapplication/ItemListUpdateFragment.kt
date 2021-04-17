package com.example.warehousemobileapplication

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.warehousemobileapplication.R
import com.example.warehousemobileapplication.data.Product
import com.example.warehousemobileapplication.data.ProductViewModel
import kotlinx.android.synthetic.main.fragment_item_list_update.*
import kotlinx.android.synthetic.main.fragment_item_list_update.view.*


class ItemListUpdateFragment : Fragment() {

    private val args by navArgs<ItemListUpdateFragmentArgs>()

    private lateinit var mProductViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_item_list_update, container, false)

        mProductViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        view.txt_updateproduct_barcode.setText(args.currentProduct.barcode)
        view.txt_updateproduct_pname.setText(args.currentProduct.productName)
        view.txt_updateproduct_cname.setText(args.currentProduct.companyName)
        view.txt_updateproduct_ptype.setText(args.currentProduct.productType)
        view.txt_updateproduct_pprice.setText(args.currentProduct.productPrice)

        view.btn_updateproduct_update.setOnClickListener {
            updateItem()
        }

        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem(){
        val upbarcode = txt_updateproduct_barcode.text.toString()
        val upproductName = txt_updateproduct_pname.text.toString()
        val upcompanyName = txt_updateproduct_cname.text.toString()
        val upproductType = txt_updateproduct_ptype.text.toString()
        val upproductPrice = txt_updateproduct_pprice.text.toString()

        if (inputCheck(upbarcode,upproductName,upcompanyName,upproductType,upproductPrice)){
            val updateProduct = Product(args.currentProduct.id, upbarcode,upproductName,upcompanyName,upproductType,upproductPrice)
            mProductViewModel.updateProduct(updateProduct)
            Toast.makeText(requireContext(), "Updated Successfully", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_itemListUpdateFragment_to_itemListFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(barcode: String, productName: String, companyName: String, productType: String, productPrice: String): Boolean{
        return !(TextUtils.isEmpty(barcode) && TextUtils.isEmpty(productName) && TextUtils.isEmpty(companyName) && TextUtils.isEmpty(productName) && TextUtils.isEmpty(productType) && TextUtils.isEmpty(productPrice))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deleteProduct()
        }
        return  super.onOptionsItemSelected(item)
    }

    private fun deleteProduct(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mProductViewModel.deleteProduct(args.currentProduct)
            Toast.makeText(requireContext(), "Successfully removed: ${args.currentProduct.barcode}", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentProduct.barcode}?")
        builder.setMessage("Are you sure you want delete ${args.currentProduct.barcode}?")
        builder.create().show()
    }
}