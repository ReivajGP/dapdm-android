package com.rgp.primerproyecto.ejercicio_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.rgp.primerproyecto.R

class ConfirmPersonalDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_personal_details)

        val userName: TextView = findViewById(R.id.tvPDCName)
        val userLastName: TextView = findViewById(R.id.tvPDCLastName)
        val userMaternalLastName: TextView = findViewById(R.id.tvPDCMaternalLastName)
        val userAge: TextView = findViewById(R.id.tvPDCAge)

        intent.extras?.let { userDetailsBundle ->
            if (userDetailsBundle.containsKey("KEY_USER_PD")) {
                val user: PersonalDetailsUser = userDetailsBundle.getSerializable("KEY_USER_PD") as PersonalDetailsUser
                userName.text = user.name
                userLastName.text = user.lastName
                userMaternalLastName.text = user.maternalLastName
                userAge.text = user.age.toString()
            } else {
                noUserDetailsFound()
            }
        } ?: noUserDetailsFound()
    }

    private fun noUserDetailsFound() {
        Toast.makeText(this, "No se encontró el objeto especificado", Toast.LENGTH_SHORT).show()
    }
}