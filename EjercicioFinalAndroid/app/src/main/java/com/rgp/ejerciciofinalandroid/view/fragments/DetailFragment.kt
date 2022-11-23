package com.rgp.ejerciciofinalandroid.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.rgp.ejerciciofinalandroid.databinding.FragmentDetailBinding
import com.rgp.ejerciciofinalandroid.R
import com.rgp.ejerciciofinalandroid.model.entities.Animal
import com.rgp.ejerciciofinalandroid.model.entities.Sex
import com.rgp.ejerciciofinalandroid.viewmodel.ListViewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private var animal: Animal? = null
    private val args: DetailFragmentArgs by navArgs()
    private val animalViewModel: ListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        setupView()
        animal = args.animal
        animal?.let { animal ->
            Glide.with(binding.root).load(animal.image).centerCrop().into(binding.ivPic)
            binding.tvName.text = animal.name
            binding.tvWeight.text = "${animal.weight} Kg"
            if (animal.sex == Sex.MALE) binding.rgSex.check(R.id.rbMale) else if (animal.sex == Sex.FEMALE) binding.rgSex.check(R.id.rbFemale)
            binding.cbMorning.isChecked = animal.description.morningCheck
            binding.cbAfternoon.isChecked = animal.description.afternoonCheck
            binding.cbNight.isChecked = animal.description.nightCheck
            binding.tvDescription.text = animalViewModel.formatDescription(animal.description.log)
        }
    }

    private fun setupView() {
        (activity as AppCompatActivity).supportActionBar?.title = "Detalle"
        binding.rbMale.isEnabled = false
        binding.rbFemale.isEnabled = false
        binding.cbMorning.isEnabled = false
        binding.cbAfternoon.isEnabled = false
        binding.cbNight.isEnabled = false
    }
}