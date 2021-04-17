package com.example.warehousemobileapplication.ui.stockin

import androidx.lifecycle.LiveData
import androidx.room.*

interface StockInDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStockIn(stockin: StockIn)

    @Update
    suspend fun updateStockIn(stockin: StockIn)

    @Delete
    suspend fun deleteStockIn(stockin: StockIn)

    @Query("DELETE FROM stockin_table")
    suspend fun deleteAllStockIn()

    @Query("SELECT * FROM stockin_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<StockIn>>
}