package com.rgp.ejerciciofinalandroid.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.rgp.ejerciciofinalandroid.databinding.FragmentDetailBinding
import com.rgp.ejerciciofinalandroid.R
import com.rgp.ejerciciofinalandroid.model.entities.Animal
import com.rgp.ejerciciofinalandroid.model.entities.Sex
import com.rgp.ejerciciofinalandroid.viewmodel.DetailViewModel
import com.rgp.ejerciciofinalandroid.viewmodel.ListViewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private var animal: Animal? = null
    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.detail_fragment_title)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        animal = args.animal
        animal?.let { animal ->
            setupView()
            fillUpView()
            setupAnimalLogObserver()
            setupButtonAction()
        }
    }

    private fun setupView() {
        binding.rbMale.isEnabled = false
        binding.rbFemale.isEnabled = false
        binding.cbMorning.isEnabled = false
        binding.cbAfternoon.isEnabled = false
        binding.cbNight.isEnabled = false
    }

    private fun fillUpView() {
        animal?.let { animal ->
            Glide.with(binding.root).load(animal.image).centerCrop().into(binding.ivPic)
            binding.tvName.text = animal.name
            binding.tvWeight.text = String.format(getString(R.string.detail_fragment_weight), "${animal.weight}") //"${animal.weight} Kg"
            if (animal.sex == Sex.MALE) binding.rgSex.check(R.id.rbMale) else if (animal.sex == Sex.FEMALE) binding.rgSex.check(R.id.rbFemale)
            binding.cbMorning.isChecked = animal.description.morningCheck
            binding.cbAfternoon.isChecked = animal.description.afternoonCheck
            binding.cbNight.isChecked = animal.description.nightCheck
            detailViewModel.getAnimalsLogs(requireContext(), animal.regId)
        }
    }

    private fun setupButtonAction() {
        binding.btAddLogEntry.setOnClickListener {
            animal?.let { animal ->
                val action = DetailFragmentDirections.actionDetailFragmentToEntryFragment(animal)
                findNavController().navigate(action)
            }
        }
    }

    private fun setupAnimalLogObserver() {
        detailViewModel.logs.observe(viewLifecycleOwner) { updatedLogs ->
            val animalLogs: ArrayList<String> = arrayListOf()
            for (log in updatedLogs) {
                animalLogs.add(log.log)
            }
            binding.tvDescription.text = detailViewModel.formatDescription(animalLogs)
        }
    }
}