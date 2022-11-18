package com.rgp.primerproyecto.ejercicio_tres

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.bumptech.glide.Glide
import com.rgp.primerproyecto.R
import com.rgp.primerproyecto.ejercicios_clase.Usuario

class DBUpdateAnimalActivity : AppCompatActivity() {

    lateinit var tvTitle: TextView
    lateinit var etAnimalName: EditText
    lateinit var etAnimalURL: EditText
    lateinit var ivAnimalPreview: ImageView
    lateinit var btUpdate: Button
    lateinit var btDelete: Button

    // Properties
    private var buttonWillPreview: Boolean = true
    private val sqlHelper = AnimalsSQLHelper(this)
    lateinit var recoveredAnimal: AnimalSQLModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_add_animal)

        tvTitle = findViewById(R.id.tvTitle)
        etAnimalName = findViewById(R.id.etAnimalName)
        etAnimalURL = findViewById(R.id.etAnimalUrl)
        ivAnimalPreview = findViewById(R.id.ivAnimalPreview)
        btUpdate = findViewById(R.id.btFirst)
        btDelete = findViewById(R.id.btSecond)

        intent.extras?.let {
            if (it.containsKey("KEY_ANIMAL")) {
                val animal = it.getSerializable("KEY_ANIMAL") as AnimalSQLModel
                recoveredAnimal = animal
                etAnimalName.setText(animal.name)
                etAnimalURL.setText(animal.image)

                Glide
                    .with(this)
                    .load(animal.image)
                    .placeholder(R.drawable.ic_broken_image)
                    .centerCrop()
                    .into(ivAnimalPreview)
            }
        }

        tvTitle.text = "Actualizar/Eliminar"
        btUpdate.text = "PREVISUALIZAR"
        btDelete.text = "ELIMINAR"
        btDelete.setBackgroundColor(Color.RED)

        // PREVISUALIZACIÓN / ACTUALIZACIÓN
        btUpdate.setOnClickListener {
            if (etAnimalName.text.isNotEmpty() && etAnimalURL.text.isNotEmpty()) {
                if (buttonWillPreview) {
                    showPreview()
                } else {
                    updateDataToDB()
                }
            } else {
                ToastHelper().showToast(this, "Debes llenar ambos campos")
            }
        }

        btDelete.setOnClickListener {
            deleteDBRegister(recoveredAnimal.id)
        }
    }

    private fun showPreview() {
        buttonWillPreview = false
        btUpdate.text = "ACTUALIZAR"
        btUpdate.setBackgroundColor(Color.BLACK)

        Glide
            .with(this)
            .load(etAnimalURL.text.toString())
            .placeholder(R.drawable.ic_broken_image)
            .centerCrop()
            .into(ivAnimalPreview)
    }

    private fun updateDataToDB() {
        val animalToUpdate = AnimalSQLModel(id = recoveredAnimal.id ,name = etAnimalName.text.toString(), image = etAnimalURL.text.toString())
        val saveSuccess: Int = sqlHelper.updateAnimal(animalToUpdate)
        if (saveSuccess > -1) {
            ToastHelper().showToast(this, "Animal guardado exitosamente")
        } else {
            ToastHelper().showToast(this, "Hubo un problema al guardar el elemento")
        }
        btUpdate.isEnabled = false
    }

    private fun deleteDBRegister(id: Int) {
        var result = sqlHelper.deleteUser(id)
        if (result > -1) {
            Toast.makeText(this, "Información eliminada correctamente :D!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Información NO eliminada x_x", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Glide.get(this).clearMemory()
    }
}