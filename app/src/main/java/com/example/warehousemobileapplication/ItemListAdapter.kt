package com.example.warehousemobileapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.warehousemobileapplication.data.Product
import kotlinx.android.synthetic.main.recyclerview_itemlist.view.*

class ItemListAdapter: RecyclerView.Adapter<ItemListAdapter.MyViewHolder>() {
    private var productList = emptyList<Product>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_itemlist, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.itemView.txt_rv_addproduct_barcode.text = currentItem.barcode.toString()
        holder.itemView.txt_rv_addproduct_productname.text = currentItem.productName.toString()
        holder.itemView.txt_rv_addproduct_companyname.text = currentItem.companyName.toString()
        holder.itemView.txt_rv_addproduct_producttype.text = currentItem.productType.toString()
        holder.itemView.txt_rv_addproduct_productprice.text = currentItem.productPrice.toString()

        holder.itemView.item_list_row_layout.setOnClickListener {
            val action = ItemListFragmentDirections.actionItemListFragmentToItemListUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(product: List<Product>){
        this.productList = product
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}