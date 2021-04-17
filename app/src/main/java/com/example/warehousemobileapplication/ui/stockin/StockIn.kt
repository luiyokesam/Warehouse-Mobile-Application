package com.example.warehousemobileapplication.ui.stockin

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "stockin_table")
data class StockIn(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val barcode: String,
    val inquantity: Int
): Parcelable