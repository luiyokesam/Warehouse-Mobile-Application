package com.example.warehousemobileapplication.ui.stockin

import androidx.lifecycle.LiveData

class StockInRepository(private val stockinDao: StockInDao)  {
    val readAllData : LiveData<List<StockIn>> = stockinDao.readAllData()

    suspend fun addStockIn(stockin: StockIn){
        stockinDao.addStockIn(stockin)
    }

    suspend fun updateStockIn(stockin: StockIn){
        stockinDao.updateStockIn(stockin)
    }

    suspend fun deleteStockIn(stockin: StockIn){
        stockinDao.deleteStockIn(stockin)
    }
    suspend fun deleteAllStockIn(){
        stockinDao.deleteAllStockIn()
    }
}