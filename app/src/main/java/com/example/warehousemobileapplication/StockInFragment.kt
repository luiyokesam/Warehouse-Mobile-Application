package com.example.warehousemobileapplication

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stock_in, container, false)

        //Recyclerview
        val adapter = StockInAdapter()
        val recyclerView = view.stock_in_list
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //UserViewModel
        mStockInViewModel = ViewModelProvider(this).get(StockInViewModel::class.java)
        mStockInViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        view.btn_stockin_float.setOnClickListener {
            findNavController().navigate(R.id.action_stockInFragment_to_stockInDetailsFragment)
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.delete_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu_delete) {
//            deleteAllUsers()
//        }
//        return super.onOptionsItemSelected(item)
//    }

    private fun deleteStockIn() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mStockInViewModel.deleteAllUsers()
            Toast.makeText(
                requireContext(),
                "Successfully removed everything",
                Toast.LENGTH_SHORT
            ).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }
}