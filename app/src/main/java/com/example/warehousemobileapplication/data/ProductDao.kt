package com.example.warehousemobileapplication.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addProduct(product: Product)

    @Update
    suspend fun  updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("DELETE FROM product_table")
    suspend fun deleteAllProduct()

    @Query("SELECT * FROM product_table ORDER BY id ASC")
    fun realAllData(): LiveData<List<Product>>
}