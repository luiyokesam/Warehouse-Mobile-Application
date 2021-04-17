package com.example.warehousemobileapplication.ui.stocktransfer

import androidx.lifecycle.LiveData
import androidx.room.*

interface StockTransferDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStockTransfer(stocktransfer: StockTransfer)

    @Update
    suspend fun updateStockTransfer(stocktransfer: StockTransfer)

    @Delete
    suspend fun deleteStockTransfer(stocktransfer: StockTransfer)

    @Query("DELETE FROM stocktransfer_table")
    suspend fun deleteAllStockTransfer()

    @Query("SELECT * FROM stocktransfer_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<StockTransfer>>
}