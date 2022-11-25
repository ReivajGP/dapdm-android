package com.rgp.ejerciciofinalandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rgp.ejerciciofinalandroid.model.entities.Animal
import com.rgp.ejerciciofinalandroid.model.repository.AnimalsRepository

class ListViewModel : ViewModel() {
    val list = MutableLiveData<ArrayList<Animal>>()

    init {
        getAnimalsList()
    }

    fun getAnimalsList() {
        val animals = AnimalsRepository.getFakeAnimals()
        list.postValue(animals)
    }
}