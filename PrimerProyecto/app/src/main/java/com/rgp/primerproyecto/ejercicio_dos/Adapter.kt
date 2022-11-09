package com.rgp.primerproyecto.ejercicio_dos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rgp.primerproyecto.R

class Adapter(private val animalsList : ArrayList<Animal>, private val listener: RecyclerAnimalListener) : RecyclerView.Adapter<Adapter.AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_animal,
        parent, false)
        return AnimalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val currentItem = animalsList[position]
        holder.tvAnimalName.text = currentItem.name
        holder.ivAnimalImage.setImageResource(currentItem.image)
        holder.tvAnimalName.setOnClickListener{
            listener.onAnimalSelected(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return animalsList.size
    }

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvAnimalName: TextView
        val ivAnimalImage: ImageView

        init {
            tvAnimalName = itemView.findViewById(R.id.tvAnimalName)
            ivAnimalImage = itemView.findViewById(R.id.ivAnimalImage)
        }
    }
}
