package com.example.warehousemobileapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.warehousemobileapplication.databinding.FragmentStockInBinding

class StockInFragment : Fragment() {
    private var binding: FragmentStockInBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStockInBinding.inflate(inflater, container, false)

        fragmentBinding.btnStockinFloat.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_stockInFragment_to_stockInDetailsFragment)
        }

        //initialize to binding
        binding = fragmentBinding
        //create view with inflated fragmentBinding
        return fragmentBinding.root
    }


}