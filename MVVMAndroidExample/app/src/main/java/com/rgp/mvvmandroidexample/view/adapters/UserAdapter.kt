package com.rgp.mvvmandroidexample.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rgp.mvvmandroidexample.R
import com.rgp.mvvmandroidexample.databinding.UserItemBinding
import com.rgp.mvvmandroidexample.model.entities.User

class UserAdapter(private var items: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var onItemTap: ((User) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position], onItemTap)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class UserViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User, onItemTap: ((User) -> Unit)?) {
            binding.user = user
//            binding.tvName.text = "Nombre: ${user.name}"
//            binding.tvLastName.text = "Apellido:${user.lastName}"
//            binding.tvAge.text = "Edad: ${user.age}"

            user?.image?.let {
                Glide.with(binding.root).load(it).centerCrop().placeholder(R.mipmap.ic_launcher).into(binding.userImage)
            }


            binding.userCard.setOnClickListener {
                onItemTap?.invoke(user)
            }
        }
    }

    fun updateItems(newItems: ArrayList<User>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}