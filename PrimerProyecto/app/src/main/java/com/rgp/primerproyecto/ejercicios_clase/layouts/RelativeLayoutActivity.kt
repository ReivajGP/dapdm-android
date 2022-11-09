package com.rgp.primerproyecto.ejercicios_clase.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.rgp.primerproyecto.R

class RelativeLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        val cbCredit: CheckBox = findViewById(R.id.cbCredit)
        val btSend: Button = findViewById(R.id.btSend)
        val rgSex: RadioGroup = findViewById(R.id.rgSex)
        val spinner: Spinner = findViewById(R.id.spinner)
        val datosSpinner = arrayListOf("Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5", "Elemento 6")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, datosSpinner)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador
        cbCredit.isChecked = true
        rgSex.check(R.id.rbMas)

        // Radio group
        rgSex.setOnCheckedChangeListener { _, id ->
            val selectedValue: String = when(id) {
                R.id.rbMas -> "Masculino"
                R.id.rbFem -> "Femenino"
                else -> "Opción no definida"
            }
            Toast.makeText(this, "Radio button selected: $selectedValue", Toast.LENGTH_SHORT).show()
        }

        // Checkbox
        cbCredit.setOnCheckedChangeListener { _ , isChecked ->
            btSend.isEnabled = isChecked != false
            Toast.makeText(this, "isChecked: $isChecked", Toast.LENGTH_SHORT).show()
        }

        // Button
        btSend.setOnClickListener {
            val userHasCreditCard: Boolean = cbCredit.isChecked
            val itemSelectedAtPos: Int = spinner.selectedItemPosition
            val spinnerItem: String = datosSpinner[itemSelectedAtPos]
            val selectedValue: String = when (rgSex.checkedRadioButtonId) {
                R.id.rbMas -> "Masculino"
                R.id.rbFem -> "Femenino"
                else -> "Opción no definida"
            }
            Toast.makeText(this, "Credit?: $userHasCreditCard\nGender selected: $selectedValue\nitemSelected: $spinnerItem", Toast.LENGTH_SHORT).show()
        }

        // Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = datosSpinner[position]
                Toast.makeText(this@RelativeLayoutActivity, "Selected: $itemSelected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}