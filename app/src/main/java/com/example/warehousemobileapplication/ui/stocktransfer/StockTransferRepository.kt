package com.example.warehousemobileapplication.ui.stocktransfer

import androidx.lifecycle.LiveData
import com.example.warehousemobileapplication.ui.stockin.StockIn
import com.example.warehousemobileapplication.ui.stockin.StockInDao

class StockTransferRepository(private val stocktransferDao: StockTransferDao) {
    val readAllData: LiveData<List<StockTransfer>> = stocktransferDao.readAllData()

    suspend fun addStockTransfer(stocktransfer: StockTransfer){
        stocktransferDao.addStockTransfer(stocktransfer)
    }

    suspend fun updateStockTransfer(stocktransfer: StockTransfer){
        stocktransferDao.updateStockTransfer(stocktransfer)
    }

    suspend fun deleteStockTransfer(stocktransfer: StockTransfer){
        stocktransferDao.deleteStockTransfer(stocktransfer)
    }

    suspend fun  deleteAllStockTransfer(){
        stocktransferDao.deleteAllStockTransfer()
    }
}