package com.rgp.primerproyecto.ejercicio_dos

import android.content.Context
import androidx.fragment.app.Fragment
import com.rgp.primerproyecto.R

class AnimalDataManager(private val context: AnimalsListFragment) {

    // Properties
    val animalName = arrayOf(
        context.getString(R.string.excercise_two_bear),
        context.getString(R.string.excercise_two_dog),
        context.getString(R.string.excercise_two_cat),
        context.getString(R.string.excercise_two_puma),
        context.getString(R.string.excercise_two_eagle),
        context.getString(R.string.excercise_two_tlacuache),
        context.getString(R.string.excercise_two_squirrel),
        context.getString(R.string.excercise_two_swan)
    )

    val animalImage = arrayOf(
        R.drawable.oso,
        R.drawable.perro,
        R.drawable.gato,
        R.drawable.puma,
        R.drawable.aguila,
        R.drawable.tlacuache,
        R.drawable.ardilla,
        R.drawable.cisne
    )

    val animalDisease = arrayOf(
        true,
        false,
        false,
        false,
        true,
        false,
        false,
        true
    )

    val animalGender = arrayOf(
        false,
        true,
        true,
        true,
        false,
        true,
        true,
        false
    )

    val animalLocation = arrayOf(
        context.getString(R.string.excercise_two_location_a),
        context.getString(R.string.excercise_two_location_b),
        context.getString(R.string.excercise_two_location_c),
        context.getString(R.string.excercise_two_location_d),
        context.getString(R.string.excercise_two_location_e),
        context.getString(R.string.excercise_two_location_f),
        context.getString(R.string.excercise_two_location_g),
        context.getString(R.string.excercise_two_location_h)
    )

    val animalAge = arrayOf(
        12, 34, 20, 12, 23, 3, 9, 8
    )

    // Private methods
    private fun getAnimalName(id: Int) : String {
        return animalName[id]
    }

    private fun getAnimalImage(id: Int) : Int {
        return animalImage[id]
    }

    private fun getAnimalDisease(id: Int) : Boolean {
        return animalDisease[id]
    }

    private fun getAnimalGender(id: Int) : Boolean {
        return animalGender[id]
    }

    private fun getAnimalLocation(id: Int) : String {
        return animalLocation[id]
    }

    private fun getAnimalAge(id: Int) : Int {
        return animalAge[id]
    }

    // Public methods
    fun getAnimalsToDisplay() : ArrayList<Animal> {
        val animals = arrayListOf<Animal>()
        for (index in animalImage.indices) {
            val animal = Animal(
                getAnimalName(index),
                getAnimalImage(index),
                getAnimalDisease(index),
                getAnimalGender(index),
                getAnimalLocation(index),
                getAnimalAge(index)
            )
            animals.add(animal)
        }
        return animals
    }
}