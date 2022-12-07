package com.example.calculator_for_agg

import com.example.calculator_for_agg.entity.AggData

const val Agg_edit = "Edit"
const val Agg_delete = "Delete"

interface listenerClick{
    fun onDeleteListener(aggData: AggData)
    fun onEditListener(aggData: AggData)

}