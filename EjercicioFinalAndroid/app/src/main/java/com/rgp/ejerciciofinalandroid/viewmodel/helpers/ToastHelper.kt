package com.rgp.ejerciciofinalandroid.viewmodel.helpers

import android.content.Context
import android.widget.Toast

class ToastHelper {
    fun displayToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}