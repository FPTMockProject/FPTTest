package com.example.common

import java.text.SimpleDateFormat
import java.util.*

fun Date.toDateTimeString(): String {
    val dateFormatter = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    return dateFormatter.format(this)
}