package com.rgp.primerproyecto.ejercicios_clase.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rgp.primerproyecto.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}