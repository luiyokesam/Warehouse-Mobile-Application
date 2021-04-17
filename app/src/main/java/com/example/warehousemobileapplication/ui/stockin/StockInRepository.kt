package com.example.warehousemobileapplication.ui.stockin

import androidx.lifecycle.LiveData

class StockInRepository(private val stockinDao: StockInDao) {
    val readAllData: LiveData<List<StockIn>> = stockinDao.readAllData()

    suspend fun addStockIn(user: StockIn){
        stockinDao.addStockIn(user)
    }

    suspend fun updateStockIn(user: StockIn){
        stockinDao.updateStockIn(user)
    }

    suspend fun deleteStockIn(user: StockIn){
        stockinDao.deleteStockIn(user)
    }

    suspend fun  deleteAllStockIn(){
        stockinDao.deleteAllStockIn()
    }
}