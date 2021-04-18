package com.example.warehousemobileapplication.data

import androidx.lifecycle.LiveData

class ProductReposiitory(private val productDao: ProductDao) {
    val readAllData : LiveData<List<Product>> = productDao.realAllData()

    suspend fun addProduct(product: Product){
        productDao.addProduct(product)
    }

    suspend fun updateProduct(product: Product){
        productDao.updateProduct(product)
    }

    suspend fun deleteProduct(product: Product){
        productDao.deleteProduct(product)
    }
    suspend fun deleteAllProduct(){
        productDao.deleteAllProduct()
    }
}