package com.example.calculator_for_agg.aggBindingAdapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.calculator_for_agg.entity.AggData
import com.example.calculator_for_agg.formattedDateTime

@BindingAdapter("android:setQuantity")
fun setQuantity(textView:TextView,num:Int){

    textView.text = num.toString()

}

@BindingAdapter("android:setRetailRate")
fun setRetailRate(textView:TextView,num:Double){

    textView.text = num.toString()

}

@BindingAdapter("android:setTotalRate")
fun setTotalRate(textView:TextView,num:Double){

    textView.text = num.toString()

}

@BindingAdapter("android:setProfit")
fun setProfit(textView:TextView,num:Double){

    textView.text = num.toString()

}
@BindingAdapter("android:setDate")
fun setDate(textView:TextView,date:Long){

    textView.text= formattedDateTime(date,"dd/MM/yyyy")
}

@BindingAdapter("android:setTime")
fun setTime(textView:TextView,time:Long){

    textView.text= formattedDateTime(time,"hh:mm a")
}