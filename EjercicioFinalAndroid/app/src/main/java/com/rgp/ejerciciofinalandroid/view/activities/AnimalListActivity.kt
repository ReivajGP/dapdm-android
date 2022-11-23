package com.rgp.ejerciciofinalandroid.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rgp.ejerciciofinalandroid.R
import com.rgp.ejerciciofinalandroid.databinding.ActivityAnimalListBinding
import com.rgp.ejerciciofinalandroid.view.fragments.ListFragment

class AnimalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ListFragment())
            .commit()
    }
}