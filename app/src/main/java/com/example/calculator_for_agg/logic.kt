package com.example.calculator_for_agg

class Calculator{

    fun totalPrice(qn:Int,rt:Double):Double{
        val total = qn*rt

        return total
    }

    fun price_Profit (qn:Int,wh:Double,rt:Double ):Double{

        val pro = rt-wh //(7.50-6.5)
        val full_profit=pro*qn

        //double number format(1.00000..=1.0)
        val profit = String.format("%.2f",full_profit).toString().toDouble()


        return profit


    }
}