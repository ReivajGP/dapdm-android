package com.rgp.primerproyecto.ejercicios_clase.layouts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rgp.primerproyecto.R

class UserAdapter(private val items: ArrayList<RecyclerViewUser>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userName: TextView
        val userImage: ImageView

        init {
            userName = view.findViewById(R.id.tvUserName)
            userImage = view.findViewById(R.id.ivUserImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userName.text = items[position].name
    }

    override fun getItemCount(): Int {
        return items.size
    }
}