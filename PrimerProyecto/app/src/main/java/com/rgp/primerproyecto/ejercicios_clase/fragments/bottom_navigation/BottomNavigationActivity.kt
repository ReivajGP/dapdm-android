package com.rgp.primerproyecto.ejercicios_clase.fragments.bottom_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rgp.primerproyecto.R

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val menu: BottomNavigationView = findViewById(R.id.menu)

        replaceFragment(FragmentOptionOne())
        menu.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.option_1 -> {
                    replaceFragment(FragmentOptionOne())
                    return@setOnItemSelectedListener true
                }
                R.id.option_2 -> {
                    replaceFragment(FragmentOptionTwo())
                    return@setOnItemSelectedListener true
                }
                R.id.option_3 -> {
                    replaceFragment(FragmentOptionThree())
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragments_container, fragment)
            .commit()
    }
}