package com.rgp.primerproyecto.ejercicios_clase.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rgp.primerproyecto.R

class ExampleFragment : Fragment() {

    val TAG: String = "Fragment exaple"
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG, "Estoy en On Attach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "Estoy en On Create")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "Estoy en On Create View")
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "Estoy en On View Created")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "Estoy en On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Estoy en On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "Estoy en On Pause")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "Estoy en On Destroy View")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "Estoy en On Destroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG, "Estoy en On Detach")
    }
}