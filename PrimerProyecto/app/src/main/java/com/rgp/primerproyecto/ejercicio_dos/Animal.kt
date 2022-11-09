package com.rgp.primerproyecto.ejercicio_dos

import java.io.Serializable

data class Animal(
    val name: String,
    val image: Int,
    val hasADisease: Boolean,
    val gender: Boolean,
    val location: String,
    val age: Int
) : Serializable
