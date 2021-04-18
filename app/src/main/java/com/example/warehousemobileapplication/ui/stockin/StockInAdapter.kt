package com.example.warehousemobileapplication.ui.stockin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.warehousemobileapplication.R
import com.example.warehousemobileapplication.StockInFragmentDirections
import kotlinx.android.synthetic.main.recyclerview_stockin.view.*

class StockInAdapter: RecyclerView.Adapter<StockInAdapter.MyViewHolder>() {
    private var stockinList = emptyList<StockIn>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_stockin, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = stockinList[position]
        holder.itemView.txt_rv_stockin_barcode.text = currentItem.barcode.toString()
        holder.itemView.txt_rv_stockin_quantity.text = currentItem.inquantity.toString()
        holder.itemView.txt_rv_stockin_date.text = currentItem.indate.toString()

        holder.itemView.stockin_rowlayout.setOnClickListener {
//            val action = StockInFragmentDirections.actionItemListFragmentToItemListUpdateFragment(currentItem)
            val action = StockInFragmentDirections.actionStockInFragmentToStockInDetailsFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(product: List<StockIn>){
        this.stockinList = product
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return stockinList.size
    }
}