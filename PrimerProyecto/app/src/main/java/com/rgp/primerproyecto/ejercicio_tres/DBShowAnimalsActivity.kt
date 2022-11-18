package com.rgp.primerproyecto.ejercicio_tres

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rgp.primerproyecto.R
import com.rgp.primerproyecto.ejercicio_dos.Animal
import com.rgp.primerproyecto.ejercicio_dos.RecyclerAnimalListener

class DBShowAnimalsActivity : AppCompatActivity(), RecyclerDBAnimalListener {

    lateinit var rvAnimals: RecyclerView
    lateinit var btAddAnimal: Button
    lateinit var sqlHelper: AnimalsSQLHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_show_animals)

        sqlHelper = AnimalsSQLHelper(this)
        rvAnimals = findViewById(R.id.rvDBAnimals)
        btAddAnimal = findViewById(R.id.btAddAnimal)

        btAddAnimal.setOnClickListener {
            addAnimalButtonPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e("WARNINGS", "ON RESUME")
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        Log.e("PRINT", getAnimalsFromDB().toString())
        var animalsAdapter = AnimalsAdapter(getAnimalsFromDB(), this, this)
        rvAnimals.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvAnimals.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rvAnimals.itemAnimator = DefaultItemAnimator()
        rvAnimals.adapter = animalsAdapter
    }

    private fun getAnimalsFromDB() : ArrayList<AnimalSQLModel> {
        Log.e("LIST", sqlHelper.getAllAnimals().toString())
        return sqlHelper.getAllAnimals()
    }

    private fun addAnimalButtonPressed() {
        val intent = Intent(this, DBAddAnimalActivity::class.java)
        startActivity(intent)
    }

    override fun onAnimalSelected(animal: AnimalSQLModel) {
        val intent = Intent(this, DBUpdateAnimalActivity::class.java).apply {
            putExtra("KEY_ANIMAL", animal)
        }
        startActivity(intent)
    }
}