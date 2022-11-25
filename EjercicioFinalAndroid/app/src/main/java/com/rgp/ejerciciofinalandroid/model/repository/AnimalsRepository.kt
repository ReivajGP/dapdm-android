package com.rgp.ejerciciofinalandroid.model.repository

import com.rgp.ejerciciofinalandroid.model.entities.Animal
import com.rgp.ejerciciofinalandroid.model.entities.AnimalLog
import com.rgp.ejerciciofinalandroid.model.entities.Sex

class AnimalsRepository {

    companion object {
        fun getFakeAnimals() : ArrayList<Animal> {
            val list: ArrayList<Animal> = arrayListOf()
            list.add(
                Animal(
                    1,
                    "Galatea",
                    "https://cdn.pixabay.com/photo/2014/04/13/20/49/cat-323262_1280.jpg",
                    "Dolor en pata derecha",
                    AnimalLog(
                        true,
                        false,
                        false,
                        arrayListOf(
                            "8:40 hrs - Ingresó con aparente dolor en pata delantera derecha",
                            "10:15 hrs - baño de rutina, se le proporcionó desayuno 50 g de croquetas"
                        )
                    ),
                    1.2,
                    Sex.FEMALE
                )
            )

            list.add(
                Animal(
                    2,
                    "Doggo",
                    "https://cdn.pixabay.com/photo/2017/09/25/13/12/puppy-2785074_1280.jpg",
                    "Problema estomacal",
                    AnimalLog(
                        false,
                        false,
                        false,
                        arrayListOf(
                            "9:20 hrs - Ingresó con problema estomacal",
                            "11:05 hrs - Baño de rutina, se le proporcionó desayuno 50 g de croquetas y se administró medicamento"
                        )
                    ),
                    8.6,
                    Sex.MALE
                )
            )

            return list
        }
    }
}