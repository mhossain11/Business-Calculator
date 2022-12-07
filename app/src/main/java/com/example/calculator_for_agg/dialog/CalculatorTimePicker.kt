package com.example.calculator_for_agg.dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class CalculatorTimePicker(val callback:(Long)->Unit): DialogFragment(),TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val hourOfDay = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)
        return TimePickerDialog(requireContext(),this,hourOfDay,minute,false)
    }




    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val c = Calendar.getInstance()
        c.set(0,0,0,hourOfDay,minute)
        callback(c.timeInMillis)

    }
}