package com.rgp.ejerciciofinalandroid.model.repository

import com.rgp.ejerciciofinalandroid.model.entities.Animal

class AnimalsRepository {

    companion object {
        fun getFakeAnimals() : ArrayList<Animal> {
            val list: ArrayList<Animal> = arrayListOf()

            list.add(Animal("Pato", "url", "Un pato, que va cantando alegremente \"cuaaa cuaaa\", para cantar hacia la gente \"cuaaa cuaaa\", y les canta un bossanova ð",1.2, false))
            return list
        }
    }
}