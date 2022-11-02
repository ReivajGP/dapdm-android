package com.rgp.primerproyecto.ejercicio_final
import java.io.Serializable

data class PersonalDetailsUser (
    val name: String,
    val lastName: String,
    val maternalLastName: String,
    val age: Int
    ) : Serializable