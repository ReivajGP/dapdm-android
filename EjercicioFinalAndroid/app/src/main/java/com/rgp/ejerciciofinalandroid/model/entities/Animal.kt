package com.rgp.ejerciciofinalandroid.model.entities

import java.io.Serializable

data class Animal(
    val name: String,
    val image: String,
    val description: String,
    val weight: Double,
    val sex: Boolean
) : Serializable
