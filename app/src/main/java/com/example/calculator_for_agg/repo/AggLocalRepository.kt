package com.example.calculator_for_agg.repo

import androidx.lifecycle.LiveData
import com.example.calculator_for_agg.daos.AggDao
import com.example.calculator_for_agg.entity.AggData


class AggLocalRepository(val dao: AggDao) {

   suspend fun insert(aggData: AggData){
        dao.addAll(aggData)
    }

   suspend fun edit(aggData: AggData){
        dao.updateAll(aggData)
    }

   suspend fun remove(aggData: AggData){
        dao.deleteAll(aggData)
    }

    fun get():LiveData<List<AggData>> {
       return dao.getAll()
    }



}