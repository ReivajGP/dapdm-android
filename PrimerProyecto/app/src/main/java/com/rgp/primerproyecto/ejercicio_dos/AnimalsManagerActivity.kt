package com.rgp.primerproyecto.ejercicio_dos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rgp.primerproyecto.R
import com.rgp.primerproyecto.ejercicios_clase.fragments.FirstFragment

class AnimalsManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_manager)

        supportFragmentManager.beginTransaction()
            .replace(R.id.animals_container, AnimalsListFragment())
            .commit()
    }
}