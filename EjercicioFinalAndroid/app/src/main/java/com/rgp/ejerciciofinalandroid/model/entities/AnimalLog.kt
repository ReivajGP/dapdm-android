package com.rgp.ejerciciofinalandroid.model.entities

import java.io.Serializable

data class AnimalLog(
    val morningCheck: Boolean,
    val afternoonCheck: Boolean,
    val nightCheck: Boolean,
    val log: ArrayList<String>
) :Serializable
