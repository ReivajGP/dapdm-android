package com.rgp.primerproyecto.ejercicios_clase.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.rgp.primerproyecto.R

class FirstFragment : Fragment() {

    var name: String? = null

    companion object {
        fun newInstance(name: String): FirstFragment {
            return FirstFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_NAME", name)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            name = it.getString("ARG_NAME")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as FragmentManagerActivity).name
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val tvNext: TextView = view.findViewById(R.id.tvNext)
        tvNext.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment.newInstance(name ?: "Rei"))
                .addToBackStack("SecondFragment")
                .commit()
        }
        return view
    }
}
