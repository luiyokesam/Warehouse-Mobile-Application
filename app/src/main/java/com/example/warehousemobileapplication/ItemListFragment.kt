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
import com.example.warehousemobileapplication.data.ProductViewModel
import kotlinx.android.synthetic.main.fragment_item_list.view.*

class ItemListFragment : Fragment() {
    private lateinit var mProductViewModel: ProductViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        val adapter = ItemListAdapter()
        val recyclerView = view.recycler_view_products
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //return binding.root
        mProductViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        mProductViewModel.readAllData.observe(viewLifecycleOwner, Observer { product ->
            adapter.setData(product)
        })

        view.add_ProductButton.setOnClickListener {
            findNavController().navigate(R.id.action_itemListFragment_to_itemListDetailsFragment)
        }

        return view
    }
}

