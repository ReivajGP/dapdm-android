package com.rgp.ejerciciofinalandroid.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.rgp.ejerciciofinalandroid.R
import com.rgp.ejerciciofinalandroid.databinding.FragmentEntryBinding
import com.rgp.ejerciciofinalandroid.model.entities.Animal
import com.rgp.ejerciciofinalandroid.viewmodel.ListViewModel

class EntryFragment : Fragment(R.layout.fragment_entry) {

    private lateinit var binding: FragmentEntryBinding
    private var animal: Animal? = null
    private val args: EntryFragmentArgs by navArgs()
    private val animalViewModel: ListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEntryBinding.bind(view)
        animal = args.animal
        setupView()
    }

    private fun setupView() {
        animal?.let{ animal ->
            binding.tvName.text = animal.name
            binding.cbMorning.isChecked = animal.description.morningCheck
            binding.cbAfternoon.isChecked = animal.description.afternoonCheck
            binding.cbNight.isChecked = animal.description.nightCheck
            binding.tvDescription.text = animalViewModel.formatDescription(animal.description.log)
        }
    }
}