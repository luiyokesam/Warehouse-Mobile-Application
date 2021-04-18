package com.example.warehousemobileapplication.ui.stockin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StockIn::class], version = 1, exportSchema = false)
abstract class StockInDatabase: RoomDatabase() {
    abstract fun stockinDao(): StockInDao

    companion object {
        @Volatile
        private var INSTANCE: StockInDatabase? = null

        fun getDatabase(context: Context): StockInDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StockInDatabase::class.java,
                    "stockin_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}