package com.rgp.mvvmandroidexample.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.rgp.mvvmandroidexample.R
import com.rgp.mvvmandroidexample.databinding.FragmentDetailBinding
import com.rgp.mvvmandroidexample.model.entities.User

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private var user: User? = null
    private val args: DetailFragmentArgs by navArgs()

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            user = it.getSerializable(ARG_USER) as? User
        }
    }*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        user = args.user
        binding.user = user
//        val name = requireActivity().getString(R.string.detail_name, user?.name)
//        val lastname = requireActivity().getString(R.string.detail_lastname, user?.lastName)
//        val age = requireActivity().getString(R.string.detail_age, user?.age.toString())

//        binding.tvName.text = name
//        binding.tvLastName.text = lastname
//        binding.tvAge.text = age
        Glide.with(binding.root).load(user?.image).centerCrop().into(binding.userImage)

    }

/*    companion object {
        private const val ARG_USER = "ARG_USER"
        fun newInstance(user: User) : DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_USER, user)
                }
            }
        }
    }*/
}