package com.example.warehousemobileapplication

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.warehousemobileapplication.data.ProductViewModel
import com.example.warehousemobileapplication.databinding.FragmentItemListBinding
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

        return  view
    }

}

