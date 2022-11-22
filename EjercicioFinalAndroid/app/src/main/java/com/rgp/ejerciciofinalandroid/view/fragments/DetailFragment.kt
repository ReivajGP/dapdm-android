package com.rgp.ejerciciofinalandroid.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.rgp.ejerciciofinalandroid.databinding.FragmentDetailBinding
import com.rgp.ejerciciofinalandroid.R
import com.rgp.ejerciciofinalandroid.model.entities.Animal

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private var animal: Animal? = null
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        animal = args.animal
        //binding.animal = animal

       // Glide.with(binding.root).load(animal?.image).centerCrop().into(binding.animalImage)

    }
}