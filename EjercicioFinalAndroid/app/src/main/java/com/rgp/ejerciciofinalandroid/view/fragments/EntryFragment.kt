package com.rgp.ejerciciofinalandroid.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rgp.ejerciciofinalandroid.R
import com.rgp.ejerciciofinalandroid.databinding.FragmentEntryBinding
import com.rgp.ejerciciofinalandroid.model.entities.Animal
import com.rgp.ejerciciofinalandroid.viewmodel.EntryViewModel
import com.rgp.ejerciciofinalandroid.viewmodel.ListViewModel

class EntryFragment : Fragment(R.layout.fragment_entry) {

    private lateinit var binding: FragmentEntryBinding
    private var animal: Animal? = null
    private val args: EntryFragmentArgs by navArgs()
    private val entryViewModel: EntryViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.entry_fragment_title)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEntryBinding.bind(view)
        animal = args.animal
        setupView()
        setupButtonAction()
        setupAnimalLogObserver()
    }

    private fun setupView() {
        animal?.let{ animal ->
            binding.tvName.text = animal.name
            binding.cbMorning.isChecked = animal.description.morningCheck
            binding.cbAfternoon.isChecked = animal.description.afternoonCheck
            binding.cbNight.isChecked = animal.description.nightCheck
            binding.tvDescription.text = entryViewModel.formatDescription(animal.description.log)
            entryViewModel.getAnimalsLogs(requireContext(), animal.regId)
        }
    }

    private fun setupButtonAction() {
        binding.btAddLogEntry.setOnClickListener {
            animal?.let { animal ->
                val wasLogSavedSuccessfully = entryViewModel.logEntryButtonPressed(
                    requireContext(),
                    binding.etHour.text.toString(),
                    binding.etMin.text.toString(),
                    binding.etLogEntry.text.toString(),
                    animal.regId
                )
                if (wasLogSavedSuccessfully) {
                    entryViewModel.getAnimalsLogs(requireContext(), animal.regId)
                }
            }
        }
    }

    private fun setupAnimalLogObserver() {
        entryViewModel.logs.observe(viewLifecycleOwner) { updatedLogs ->
            val animalLogs: ArrayList<String> = arrayListOf()
            for (log in updatedLogs) {
                animalLogs.add(log.log)
            }
            binding.tvDescription.text = entryViewModel.formatDescription(animalLogs)
        }
    }
}