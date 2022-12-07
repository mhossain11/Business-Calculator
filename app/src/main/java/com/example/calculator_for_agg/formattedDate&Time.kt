package com.example.calculator_for_agg

import android.provider.ContactsContract
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

fun formattedDateTime(millie:Long,format:String)=
    SimpleDateFormat(format, Locale.getDefault()).format(Date(millie))