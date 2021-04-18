package com.example.warehousemobileapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warehousemobileapplication.databinding.FragmentStockInBinding
import com.example.warehousemobileapplication.ui.stockin.StockInAdapter
import com.example.warehousemobileapplication.ui.stockin.StockInViewModel
import kotlinx.android.synthetic.main.fragment_stock_in.view.*

class StockInFragment : Fragment() {
    private lateinit var mStockInViewModel: StockInViewModel
    private var binding: FragmentStockInBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stock_in, container, false)

        val adapter = StockInAdapter()
        val recyclerView = view.stock_in_list
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //return binding.root
        mStockInViewModel = ViewModelProvider(this).get(StockInViewModel::class.java)
        mStockInViewModel.readAllData.observe(viewLifecycleOwner, Observer { stockin ->
            adapter.setData(stockin)
        })

        view.btn_stockin_float.setOnClickListener {
            findNavController().navigate(R.id.action_stockInFragment_to_stockInDetailsFragment)
        }

        return view
    }
}