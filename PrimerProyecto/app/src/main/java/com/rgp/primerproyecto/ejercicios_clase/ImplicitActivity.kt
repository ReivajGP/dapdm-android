package com.rgp.primerproyecto.ejercicios_clase

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.rgp.primerproyecto.R

class ImplicitActivity : AppCompatActivity() {
    val TAG: String = "ImplicitActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)

        val button = findViewById<Button>(R.id.button_mandar_correo)
        val email: Intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf("informaticorp80@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "Aviso urgente")
            putExtra(Intent.EXTRA_TEXT, "Este es mi primer intent")
        }

        button.setOnClickListener {
            Log.e(TAG, "Sending email...")
            startActivity(Intent.createChooser(email, "Test"))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause")
    }
    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }
}