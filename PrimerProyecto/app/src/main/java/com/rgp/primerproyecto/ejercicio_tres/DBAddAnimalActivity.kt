package com.rgp.primerproyecto.ejercicio_tres

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.rgp.primerproyecto.R

class DBAddAnimalActivity : AppCompatActivity() {

    // GRAPHIC ELEMENTS TO USE
    lateinit var etAnimalName: EditText
    lateinit var etAnimalURL: EditText
    lateinit var ivAnimalPreview: ImageView
    lateinit var btSave: Button
    lateinit var btEmpty: Button

    // Properties
    private var buttonWillPreview: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_add_animal)

        setupActivity()

        btSave.setOnClickListener {
            if (etAnimalName.text.isNotEmpty() && etAnimalURL.text.isNotEmpty()) {
                if (buttonWillPreview) {
                    showPreview()
                } else {
                    saveDataToDB()
                }
            } else {
                ToastHelper().showToast(this, "Debes llenar ambos campos")
            }
        }
    }

    private fun setupActivity() {
        etAnimalName = findViewById(R.id.etAnimalName)
        etAnimalURL = findViewById(R.id.etAnimalUrl)
        ivAnimalPreview = findViewById(R.id.ivAnimalPreview)
        btSave = findViewById(R.id.btSecond)
        btEmpty = findViewById(R.id.btFirst)

        btEmpty.isVisible = false
        btSave.text = "PREVISUALIZAR"
    }

    private fun showPreview() {
        buttonWillPreview = false
        btSave.text = "GUARDAR"
        btSave.setBackgroundColor(Color.RED)

        Glide
            .with(this)
            .load(etAnimalURL.text)
            .placeholder(R.drawable.ic_broken_image)
            .centerInside()
            .into(ivAnimalPreview)
    }

    private fun saveDataToDB() {
        val sqlHelper = AnimalsSQLHelper(this)
        val animalToSave = AnimalSQLModel(name = etAnimalName.text.toString(), image = etAnimalURL.text.toString())
        val saveSuccess: Long = sqlHelper.insert(animalToSave)
        if (saveSuccess > -1) {
            ToastHelper().showToast(this, "Animal guardado exitosamente")
        } else {
            ToastHelper().showToast(this, "Hubo un problema al guardar el elemento")
        }
        btSave.isEnabled = false
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Glide.get(this).clearMemory()
    }
}