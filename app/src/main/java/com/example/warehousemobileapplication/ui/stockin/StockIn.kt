package com.example.warehousemobileapplication.ui.stockin

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "stockin_table")
data class StockIn (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var barcode: String,
    var inquantity: Int,
    var indate: String
): Parcelable
