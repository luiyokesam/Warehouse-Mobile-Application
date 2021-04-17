package com.example.warehousemobileapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var barcode: String,
    var productName: String,
    var companyName: String,
    var productType: String,
    var productPrice: Double
)