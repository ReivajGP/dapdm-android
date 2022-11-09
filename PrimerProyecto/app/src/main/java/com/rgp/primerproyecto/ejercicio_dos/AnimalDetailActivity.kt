package com.rgp.primerproyecto.ejercicio_dos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.rgp.primerproyecto.R

class AnimalDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_detail)

        val animalName: TextView = findViewById(R.id.tvAnimalName)
        val animalImage: ImageView = findViewById(R.id.ivAnimalImage)
        val animalHasDisease: CheckBox = findViewById(R.id.cbDisease)
        val animalGender: RadioGroup = findViewById(R.id.rgGender)
        val animalLocation: TextView = findViewById(R.id.tvLocation)
        val animalAge: TextView = findViewById(R.id.tvAge)

        intent.extras?.let { animalDetailBundle ->
            if (animalDetailBundle.containsKey("KEY_ANIMAL")) {
                val animal: Animal = animalDetailBundle.getSerializable("KEY_ANIMAL") as Animal
                animalName.text = animal.name
                animalImage.setImageResource(animal.image)
                animalHasDisease.isChecked = animal.hasADisease
                if (animal.gender == false) {
                    animalGender.check(R.id.rbMale)
                } else {
                    animalGender.check(R.id.rbFemale)
                }
                animalLocation.text = "Ubicación: ${animal.location}"
                animalAge.text = "Edad: ${animal.age}"
            }
        }
    }
}