package com.example.warehousemobileapplication.ui.stockin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.warehousemobileapplication.R
import kotlinx.android.synthetic.main.recyclerview_stockin.view.*

class StockInAdapter: RecyclerView.Adapter<StockInAdapter.MyViewHolder>() {
    private var stockinList = emptyList<StockIn>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_stockin, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = stockinList[position]
        holder.itemView.txt_rv_stockin_barcode.text = currentItem.id.toString()
        holder.itemView.txt_stockin_rc_quantity.text= currentItem.inquantity.toString()
//        holder.itemView.lastName_txt.text = currentItem.lastName
//        holder.itemView.age_txt.text = currentItem.age.toString()

        holder.itemView.stockin_rowlayout.setOnClickListener{
//            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
//            val action = .actionListFragmentToUpdateFragment(currentItem)
//            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return stockinList.size
    }

    fun setData(stockin: List<StockIn>){
        this.stockinList = stockin
        notifyDataSetChanged()
    }
}