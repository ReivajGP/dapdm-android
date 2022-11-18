package com.rgp.primerproyecto.ejercicios_clase.fragments.bottom_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rgp.primerproyecto.R

class FragmentOptionThree : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_option_three, container, false)
    }
}