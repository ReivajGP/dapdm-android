package com.rgp.primerproyecto.ejercicios_clase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rgp.primerproyecto.R

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "Entré a onCreate")
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "Entré a onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Entré a onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "Entré a onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "Entré a onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "Entré a onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "Entré a onDestroy")
    }
}