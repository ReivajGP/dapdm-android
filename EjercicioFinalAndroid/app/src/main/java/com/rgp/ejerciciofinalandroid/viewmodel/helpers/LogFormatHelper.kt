package com.rgp.ejerciciofinalandroid.viewmodel.helpers

class LogFormatHelper {
    fun formatDescription(logs: ArrayList<String>) : String {
        var unifiedLog = ""
        for (log in logs) {
            unifiedLog = unifiedLog + log + "\n\n"
        }
        return unifiedLog
    }
}