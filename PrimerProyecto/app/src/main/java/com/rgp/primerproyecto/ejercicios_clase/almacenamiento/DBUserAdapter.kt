package com.rgp.primerproyecto.ejercicios_clase.almacenamiento

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rgp.primerproyecto.R

class DBUserAdapter(private val items: ArrayList<DBUser>) : RecyclerView.Adapter<DBUserAdapter.DBUserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DBUserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.db_item_user, parent, false)
        return DBUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: DBUserViewHolder, position: Int) {
        holder.name.text = items[position].name
        holder.description.text = items[position].description
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class DBUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val description: TextView

        init {
            name = view.findViewById(R.id.tvName)
            description = view.findViewById(R.id.tvDescription)
        }
    }
}
