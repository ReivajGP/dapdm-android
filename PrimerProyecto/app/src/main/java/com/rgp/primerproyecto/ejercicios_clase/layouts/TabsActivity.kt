package com.rgp.primerproyecto.ejercicios_clase.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.rgp.primerproyecto.R

class TabsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        val taps: TabLayout = findViewById(R.id.tlTaps)

        taps.addTab(taps.newTab().setText("Football"))
        taps.addTab(taps.newTab().setText("Basketball"))
        taps.addTab(taps.newTab().setIcon(android.R.drawable.arrow_up_float))

        taps.tabGravity = TabLayout.GRAVITY_FILL
    }
}