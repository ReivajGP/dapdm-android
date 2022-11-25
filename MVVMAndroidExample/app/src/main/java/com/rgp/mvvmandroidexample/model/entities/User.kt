package com.rgp.mvvmandroidexample.model.entities

import java.io.Serializable

data class User (
    val name: String,
    val lastName: String,
    val age: Int,
    val image: String
    ):Serializable