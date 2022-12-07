package com.example.calculator_for_agg.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.calculator_for_agg.entity.AggData

@Dao
interface AggDao {

    @Insert
    suspend fun addAll(aggData: AggData)

    @Update
   suspend fun updateAll(aggData: AggData)

    @Delete
   suspend fun deleteAll(aggData: AggData)

    @Query("Select * from agg_tbl order by id desc")
    fun getAll():LiveData<List<AggData>>
}