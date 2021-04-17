package com.example.warehousemobileapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class StockInTransferFragment : Fragment() {
//    private val args by navArgs<UpdateFragmentArgs>()

//    private lateinit var mStockInViewModel: StockInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout., container, false)
//
//        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
//
//        view.updateFirstName_et.setText(args.currentUser.firstName)
//        view.updateLastName_et.setText(args.currentUser.lastName)
//        view.updateAge_et.setText(args.currentUser.age.toString())
//
//        view.update_btn.setOnClickListener{
//            updateItem()
//        }

        //Add menu
        setHasOptionsMenu(true)

        return view
    }
}