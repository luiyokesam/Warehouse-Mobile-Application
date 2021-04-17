package com.example.warehousemobileapplication.ui.stocktransfer

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "stocktransfer_table")
data class StockTransfer(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val rackid: String,
    val barcode: String,
    val inquantity: Int
): Parcelable