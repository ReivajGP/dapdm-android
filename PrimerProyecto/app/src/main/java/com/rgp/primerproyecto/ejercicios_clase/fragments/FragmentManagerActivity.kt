package com.rgp.primerproyecto.ejercicios_clase.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rgp.primerproyecto.R

class FragmentManagerActivity : AppCompatActivity() {

    val name: String = "Reivaj Gómez"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_manager)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, FirstFragment.newInstance(name), "FirstFragment")
            .commit()
    }
}