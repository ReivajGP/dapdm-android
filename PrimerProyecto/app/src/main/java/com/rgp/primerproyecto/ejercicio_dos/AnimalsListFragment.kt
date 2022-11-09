package com.rgp.primerproyecto.ejercicio_dos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rgp.primerproyecto.R


class AnimalsListFragment : Fragment(), RecyclerAnimalListener {

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
        animals = AnimalDataManager(this).getAnimalsToDisplay()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(animals, this)
        recyclerView.adapter = adapter
    }

    override fun onAnimalSelected(animal: Animal) {
        passAnimalObject(animal)
    }

    private fun passAnimalObject(animal: Animal) {
        val intent = Intent(activity, AnimalDetailActivity::class.java).apply {
            putExtra("KEY_ANIMAL", animal)
        }
        startActivity(intent)
    }
}