package com.example.warehousemobileapplication.ui.stocktransfer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.warehousemobileapplication.ui.stockin.StockIn
import com.example.warehousemobileapplication.ui.stockin.StockInDatabase
import com.example.warehousemobileapplication.ui.stockin.StockInRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StockTransferViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<StockTransfer>>
    private val repository: StockTransferRepository

    init {
        val stocktransferDao = StockTransferDatabase.getDatabase(application).stocktransferDao()
        repository = StockTransferRepository(stocktransferDao)
        readAllData = repository.readAllData
    }

    fun addUser(stocktransfer: StockTransfer){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStockTransfer(stocktransfer)
        }
    }

    fun updateUser(stocktransfer: StockTransfer){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateStockTransfer(stocktransfer)
        }
    }

    fun deleteUser(stocktransfer: StockTransfer){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteStockTransfer(stocktransfer)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllStockTransfer()
        }
    }
}