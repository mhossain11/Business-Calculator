package com.example.calculator_for_agg.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calculator_for_agg.daos.AggDao
import com.example.calculator_for_agg.entity.AggData

@Database(entities = [AggData::class], version = 1, exportSchema = false)
abstract class AggDatabase:RoomDatabase() {

    abstract fun aggDao():AggDao

    companion object{
        var db: AggDatabase?=null

        fun getDb(context: Context):AggDatabase{
            return db ?: synchronized(this){
                var _db = Room.databaseBuilder(
                   context,AggDatabase::class.java,"database"
                )//.allowMainThreadQueries()
                    .build()

                db=_db
                _db
            }
        }
    }
}