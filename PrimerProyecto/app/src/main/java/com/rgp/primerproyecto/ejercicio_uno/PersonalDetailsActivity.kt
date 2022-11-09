package com.rgp.primerproyecto.ejercicio_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.rgp.primerproyecto.R

class PersonalDetailsActivity : AppCompatActivity() {

    // Activity lifecycle methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_details)

        // Views to interact with
        val userName: EditText = findViewById(R.id.etPDName)
        val userLastName: EditText = findViewById(R.id.etPDLastName)
        val userMaternalLastName: EditText = findViewById(R.id.etPDMaternalLastName)
        val userAge: EditText = findViewById(R.id.etPDAge)
        val sendDetailsButton: Button = findViewById(R.id.btPDSend)

        // Listeners
        sendDetailsButton.setOnClickListener {
            if (userName.text.toString().isEmpty() ||
                userLastName.text.toString().isEmpty() ||
                userMaternalLastName.text.toString().isEmpty() ||
                userAge.text.toString().isEmpty()) {
                Toast.makeText(this, "¡Debes llenar todos los campos para continuar!", Toast.LENGTH_SHORT).show()
            } else {
                val personalDetailsUserKey: String = "KEY_USER_PD"
                val personalDetailsUser: PersonalDetailsUser = PersonalDetailsUser(
                    userName.text.toString(),
                    userLastName.text.toString(),
                    userMaternalLastName.text.toString(),
                    userAge.text.toString().toInt()
                )
                val sendPersonalDetailsIntent = Intent(this, ConfirmPersonalDetailsActivity::class.java).apply {
                    putExtra(personalDetailsUserKey, personalDetailsUser)
                }
                startActivity(sendPersonalDetailsIntent)
            }
        }
    }
}