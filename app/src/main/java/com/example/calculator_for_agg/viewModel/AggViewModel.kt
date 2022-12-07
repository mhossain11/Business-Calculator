package com.example.calculator_for_agg.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculator_for_agg.db.AggDatabase
import com.example.calculator_for_agg.entity.AggData
import com.example.calculator_for_agg.repo.AggLocalRepository
import kotlinx.coroutines.launch

class AggViewModel(val ctx:Application):AndroidViewModel(ctx) {

    val rep = AggLocalRepository(AggDatabase.getDb(ctx).aggDao())

    fun add(aggData: AggData){
        viewModelScope.launch {
            rep.insert(aggData)
        }
    }

    fun edit(aggData: AggData){
        viewModelScope.launch {
            rep.edit(aggData)
        }
    }

    fun remove(aggData: AggData){
        viewModelScope.launch {
            rep.remove(aggData)
        }
    }

    fun getAll():LiveData<List<AggData>>{
       return rep.get()
    }
}