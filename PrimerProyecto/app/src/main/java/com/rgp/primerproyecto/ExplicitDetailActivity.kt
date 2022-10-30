package com.rgp.primerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class ExplicitDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_detail)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastname = findViewById<TextView>(R.id.tvLastname)
        val tvAge = findViewById<TextView>(R.id.tvAge)

        intent.extras?.let { bundle ->
            Log.e("ExplicitDetailActivity","Entramos a los INTENT EXTRAS")
            if (bundle.containsKey("KEY_NAME")){
                val name = bundle.getString("KEY_NAME")
                tvName.text = name
            }
            if (bundle.containsKey("KEY_LASTNAME")){
                val lastname = bundle.getString("KEY_LASTNAME")
                tvLastname.text = lastname
            }
            if (bundle.containsKey("KEY_AGE")){
                val age = bundle.getInt("KEY_AGE")
                tvAge.text = "$age"
            }

            if (bundle.containsKey("KEY_USER")) {
                val user = bundle.getSerializable("KEY_USER") as Usuario
                tvName.text = user.name
                tvLastname.text = user.lastName
                tvAge.text = "${user.age}"
            }

            if (bundle.containsKey("KEY_ET_NAME")) {
                val enteredName = bundle.getString("KEY_ET_NAME")
                Toast.makeText(this, "El nombre anterior era ${tvName.text}",Toast.LENGTH_SHORT).show()
                tvName.text = enteredName
            }
        } ?: showEmptyInfo()
    }

    private fun showEmptyInfo() {
        Log.e("ExplicitDetailActivity","VACÍO Intent Extras")
        Toast.makeText(this, "Extras vacío", Toast.LENGTH_SHORT).show()
    }
}