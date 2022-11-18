package com.rgp.primerproyecto.ejercicio_tres

import android.content.Context
import android.widget.Toast

class ToastHelper {
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}