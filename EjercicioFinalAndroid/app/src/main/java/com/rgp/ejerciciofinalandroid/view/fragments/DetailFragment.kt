package com.rgp.ejerciciofinalandroid.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.rgp.ejerciciofinalandroid.databinding.FragmentDetailBinding
import com.rgp.ejerciciofinalandroid.R
import com.rgp.ejerciciofinalandroid.model.entities.Animal
import com.rgp.ejerciciofinalandroid.model.entities.Sex

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private var animal: Animal? = null
    private val args: DetailFragmentArgs by navArgs()

    @SuppressLint("SetTextI18n")
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
            binding.tvDescription.text = formatDescription(animal.description.log)
        }
    }

    private fun setupView() {
        binding.rbMale.isEnabled = false
        binding.rbFemale.isEnabled = false
        binding.cbMorning.isEnabled = false
        binding.cbAfternoon.isEnabled = false
        binding.cbNight.isEnabled = false
    }

    private fun formatDescription(logs: ArrayList<String>) : String {
        var unifiedLog = ""
        for (log in logs) {
            unifiedLog = unifiedLog + log + "\n\n"
        }
        return unifiedLog
    }
}