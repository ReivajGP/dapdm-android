package com.rgp.primerproyecto.ejercicio_dos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rgp.primerproyecto.R

class AnimalsListFragment : Fragment() {

    private lateinit var adapter: Adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var animals: ArrayList<Animal>

    lateinit var animalName: Array<String>
    lateinit var animalImage: Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animals_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(animals)
        recyclerView.adapter = adapter
    }

    companion object {
    }

    private fun dataInit() {
        animals = arrayListOf<Animal>()

        animalName = arrayOf(
            getString(R.string.excercise_two_bear),
            getString(R.string.excercise_two_dog),
            getString(R.string.excercise_two_cat),
            getString(R.string.excercise_two_puma),
            getString(R.string.excercise_two_eagle),
            getString(R.string.excercise_two_tlacuache),
            getString(R.string.excercise_two_squirrel),
            getString(R.string.excercise_two_swan)
        )

        animalImage = arrayOf(
            R.drawable.ic_android_photo,
            R.drawable.ic_android_photo,
            R.drawable.ic_android_photo,
            R.drawable.ic_android_photo,
            R.drawable.ic_android_photo,
            R.drawable.ic_android_photo,
            R.drawable.ic_android_photo,
            R.drawable.ic_android_photo
            /*R.drawable.oso,
            R.drawable.perro,
            R.drawable.gato,
            R.drawable.puma,
            R.drawable.aguila,
            R.drawable.tlacuache,
            R.drawable.ardilla,
            R.drawable.cisne*/
        )


        for (index in animalImage.indices) {
            val animal = Animal(
                animalName[index],
                animalImage[index],
                true,
                true,
                "Africa",
                5
            )
            animals.add(animal)
        }
    }
}