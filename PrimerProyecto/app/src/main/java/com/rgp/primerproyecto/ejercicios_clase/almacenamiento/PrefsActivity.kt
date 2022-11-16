package com.rgp.primerproyecto.ejercicios_clase.almacenamiento

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import com.rgp.primerproyecto.R

class PrefsActivity : AppCompatActivity() {

    private lateinit var tvMonitor: TextView
    private lateinit var etInput: EditText
    private lateinit var btSave: Button
    private lateinit var btDelete: Button
    private lateinit var prefs: SharedPreferences
    private var PREFS_NAME: String = "userPreferences"
    private var SHARE_NAME: String = "shared_string"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prefs)

        // Properties assignment
        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        tvMonitor = findViewById(R.id.tvMonitor)
        etInput = findViewById(R.id.etInput)
        btSave = findViewById(R.id.btSave)
        btDelete = findViewById(R.id.btDelete)

        // Button listeners
        btSave.setOnClickListener{
            prefs.edit().putString(SHARE_NAME, etInput.text.toString()).apply()
            configView()
            //btSave.isVisible = false
        }

        btDelete.setOnClickListener{
            prefs.edit().remove(SHARE_NAME).apply()
            configView()
            //btSave.isVisible = true
        }

        // Mehtod execution
        configView()
    }

    private fun askInfo() {
        tvMonitor.visibility = View.INVISIBLE
        btDelete.visibility = View.INVISIBLE
        etInput.visibility = View.VISIBLE
        btSave.visibility = View.VISIBLE
    }

    private fun showInfo() {
        tvMonitor.visibility = View.VISIBLE
        btDelete.visibility = View.VISIBLE
        etInput.visibility = View.INVISIBLE
        btSave.visibility = View.INVISIBLE

        tvMonitor.text = "¡Hola, ${prefs.getString(SHARE_NAME, "NO HABÍA NADA DE NADA :(")}!"
    }

    private fun isInfoSaved() : Boolean {
        return prefs.contains(SHARE_NAME)
    }

    private fun configView() {
        if (isInfoSaved()) showInfo() else askInfo()
    }
}
