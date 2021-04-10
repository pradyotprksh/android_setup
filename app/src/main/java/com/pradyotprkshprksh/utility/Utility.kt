package com.pradyotprkshprksh.utility

import java.text.SimpleDateFormat
import java.util.*

class Utility {

    fun getDatefromTimestamp(s: String?) : String {
        var date = ""
        if (s != null) {
            try {
                val sdf = SimpleDateFormat("EEE, MMM dd yyyy")
                val netDate = Date(s.toLong())
                date = sdf.format(netDate)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return date
    }

}