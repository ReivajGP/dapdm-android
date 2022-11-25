package com.rgp.ejerciciofinalandroid.model.entities

import java.io.Serializable

data class AnimalDBLogEntry(
    val animalId: Int = 0,
    val log: String = ""
) : Serializable
