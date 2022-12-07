package com.example.calculator_for_agg.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize



@Entity(tableName = "agg_tbl")
data class AggData(
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    @ColumnInfo(name = "name") var namesw:String,
    @ColumnInfo(name = "total") val total:Double,
    @ColumnInfo var quantity:Int,
    @ColumnInfo var rate:Double,
    @ColumnInfo val profit:Double,
    @ColumnInfo var date:Long,
    @ColumnInfo var time:Long
)



