package com.rgp.primerproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)

        val btSent = findViewById<Button>(R.id.btSend)
        val etName = findViewById<EditText>(R.id.etName)

        btSent.setOnClickListener {
            val name = etName.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Nombre vacío >:(", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ExplicitDetailActivity::class.java).apply {
                    putExtra("KEY_NAME", name)
                    putExtra("KEY_LASTNAME", "Gómez")
                    putExtra("KEY_AGE", 31)
                    val user = Usuario("Javier", "Zemog", 13)
                    putExtra("KEY_USER", user)
                    putExtra("KEY_ET_NAME", name)
                }
                startActivity(intent)
            }
        }
    }
}