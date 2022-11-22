package com.rgp.mvvmandroidexample.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rgp.mvvmandroidexample.R
import com.rgp.mvvmandroidexample.databinding.FragmentListBinding
import com.rgp.mvvmandroidexample.model.entities.User
import com.rgp.mvvmandroidexample.view.adapters.UserAdapter
import com.rgp.mvvmandroidexample.viewmodel.ListViewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private val userViewModel: ListViewModel by viewModels()
    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: UserAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListBinding.bind(view)
        binding.refresh.setOnRefreshListener {
            userViewModel.getUserList()
            binding.refresh.isRefreshing = false
        }

        adapter = UserAdapter(arrayListOf())
        adapter.onItemTap = { user ->
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(user)
            findNavController().navigate(action)
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.container, DetailFragment.newInstance(it))
//                .addToBackStack("Detail fragment")
//                .commit()
        }

        binding.userList.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.userList.adapter = adapter

        userViewModel.list.observe(viewLifecycleOwner, Observer { newItems ->
            adapter.updateItems(newItems)
        })
        userViewModel.loader.observe(viewLifecycleOwner, {
            binding.loader.visibility = if (it == true) View.VISIBLE else View.GONE
            binding.userList.visibility = if (it == true) View.GONE else View.VISIBLE
        })
    }
}