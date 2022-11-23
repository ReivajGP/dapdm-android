package com.rgp.ejerciciofinalandroid.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rgp.ejerciciofinalandroid.model.entities.Animal
import com.rgp.ejerciciofinalandroid.model.repository.AnimalsRepository
import kotlin.random.Random
import kotlin.random.nextInt

class ListViewModel : ViewModel() {
    val list = MutableLiveData<ArrayList<Animal>>()
    val loader = MutableLiveData<Boolean>()

    init {
        getAnimalsList()
    }

    fun getAnimalsList() {
        loader.postValue(true)
        val postDelayed = Handler(Looper.getMainLooper()).postDelayed({
            val animals = AnimalsRepository.getFakeAnimals()
            list.postValue(animals)
            loader.postValue(false)
        },  1000)
    }
}