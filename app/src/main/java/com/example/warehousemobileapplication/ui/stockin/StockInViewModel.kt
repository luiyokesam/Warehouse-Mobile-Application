package com.example.warehousemobileapplication.ui.stockin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StockInViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<StockIn>>
    private val repository: StockInRepository

    init {
        val stockinDao = StockInDatabase.getDatabase(application).stockinDao()
        repository = StockInRepository(stockinDao)
        readAllData = repository.readAllData
    }

    fun addStockIn(stockin: StockIn){
        viewModelScope.launch(Dispatchers.IO){
            repository.addStockIn(stockin)
        }
    }

    fun updateStockIn(stockin: StockIn){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateStockIn(stockin)
        }
    }

    fun deleteStockIn(stockin: StockIn){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteStockIn(stockin)
        }
    }

    fun deleteAllStockIn(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllStockIn()
        }
    }
}