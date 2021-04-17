package com.example.warehousemobileapplication.ui.stocktransfer

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.warehousemobileapplication.ui.stockin.StockIn
import com.example.warehousemobileapplication.ui.stockin.StockInDao
import com.example.warehousemobileapplication.ui.stockin.StockInDatabase

@Database(entities = [StockTransfer::class], version = 1, exportSchema = false)
abstract class StockTransferDatabase : RoomDatabase() {
    abstract fun stocktransferDao(): StockTransferDao

    companion object {
        @Volatile
        private var INSTANCE: StockTransferDatabase? = null

        fun getDatabase(context: Context): StockTransferDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StockTransferDatabase::class.java,
                    "stocktransfer_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}