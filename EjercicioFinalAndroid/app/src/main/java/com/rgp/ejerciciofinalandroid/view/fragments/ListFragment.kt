package com.rgp.ejerciciofinalandroid.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rgp.ejerciciofinalandroid.R
import com.rgp.ejerciciofinalandroid.databinding.FragmentListBinding
import com.rgp.ejerciciofinalandroid.view.adapters.AnimalAdapter
import com.rgp.ejerciciofinalandroid.viewmodel.ListViewModel
import androidx.lifecycle.Observer

class ListFragment : Fragment(R.layout.fragment_list) {

    private val animalViewModel: ListViewModel by viewModels()
    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: AnimalAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListBinding.bind(view)
        binding.updateContent.setOnRefreshListener {
            animalViewModel.getAnimalsList()
            binding.updateContent.isRefreshing = false
        }

        adapter = AnimalAdapter(arrayListOf())
        adapter.onItemTap = { animal ->
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(animal)
            findNavController().navigate(action)
        }

        binding.animalsList.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.animalsList.adapter = adapter

        animalViewModel.list.observe(viewLifecycleOwner, Observer { newItems ->
            adapter.updateItems(newItems)
        })

        animalViewModel.loader.observe(viewLifecycleOwner, {
            binding.loader.visibility = if (it == true) View.VISIBLE else View.GONE
            binding.animalsList.visibility = if (it == true) View.GONE else View.VISIBLE
        })
    }
}