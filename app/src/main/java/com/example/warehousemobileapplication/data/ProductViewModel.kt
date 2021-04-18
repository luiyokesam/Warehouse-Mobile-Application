package com.example.warehousemobileapplication.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Product>>
    private val repository: ProductReposiitory

    init {
        val productDao = ProductDatabase.getDatabase(application).productDao()
        repository = ProductReposiitory(productDao)
        readAllData = repository.readAllData
    }

    fun addProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO){
            repository.addProduct(product)
        }
    }

    fun updateProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateProduct(product)
        }
    }

    fun deleteProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteProduct(product)
        }
    }

    fun deleteAllProduct(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllProduct()
        }
    }
}