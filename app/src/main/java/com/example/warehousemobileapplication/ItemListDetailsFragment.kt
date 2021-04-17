package com.example.warehousemobileapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.warehousemobileapplication.databinding.FragmentItemListDetailsBinding

class ItemListDetailsFragment : Fragment() {

    private var _binding: FragmentItemListDetailsBinding? = null
    private  val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListDetailsBinding.inflate(inflater, container, false)

//        viewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        viewModel.result.observe(viewLifecycleOwner, Observer {
//            val message = if (it == null){
//                getString(R.string.added_product)
//            }else{
//                getString(R.string.error, it.message)
//            }
//            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
//        })
//
//        binding.btnAddproductAdd.setOnClickListener {
//            val barcode = binding.txtAddproductBarcode.text.toString().trim()
//            val productName = binding.txtAddproductPname.text.toString().trim()
//            val companyName = binding.txtAddproductCname.text.toString().trim()
//            val productType = binding.txtAddproductPtype.text.toString().trim()
//            val productPrice = binding.txtAddproductPprice.text.toString().trim()
//
//            if(barcode.isEmpty()){
//                binding.txtAddproductBarcode.error = "This field is required"
//                return@setOnClickListener
//            }
//            if(productName.isEmpty()){
//                binding.txtAddproductPname.error = "This field is required"
//                return@setOnClickListener
//            }
//            if(companyName.isEmpty()){
//                binding.txtAddproductCname.error = "This field is required"
//                return@setOnClickListener
//            }
//            if(productType.isEmpty()){
//                binding.txtAddproductPtype.error = "This field is required"
//                return@setOnClickListener
//            }
//            if(productPrice.isEmpty()){
//                binding.txtAddproductPprice.error = "This field is required"
//                return@setOnClickListener
//            }
//
//            val product = Product()
//            product.barcode = barcode
//            product.productName = productName
//            product.companyName = companyName
//            product.productType = productType
//            product.productPrice = productPrice
//
//            viewModel.addProduct(product)
//        }
//    }
}