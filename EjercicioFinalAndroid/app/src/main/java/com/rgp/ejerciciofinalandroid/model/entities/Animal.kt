package com.rgp.ejerciciofinalandroid.model.entities

import java.io.Serializable

data class Animal(
    val regId: Int,
    val name: String,
    val image: String,
    val disease: String,
    val description: AnimalLog,
    val weight: Double,
    val sex: Sex
) : Serializable
