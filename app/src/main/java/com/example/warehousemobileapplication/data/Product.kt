package com.example.warehousemobileapplication.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "product_table")
data class Product (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var barcode: String,
    var productName: String,
    var companyName: String,
    var productType: String,
    var productPrice: String
): Parcelable