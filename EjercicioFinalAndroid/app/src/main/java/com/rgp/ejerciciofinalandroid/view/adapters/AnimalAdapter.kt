package com.rgp.ejerciciofinalandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rgp.ejerciciofinalandroid.R
import com.rgp.ejerciciofinalandroid.databinding.AnimalItemBinding
import com.rgp.ejerciciofinalandroid.model.entities.Animal
import com.rgp.ejerciciofinalandroid.model.entities.AnimalBrief

class AnimalAdapter(private var items: ArrayList<Animal>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    var onItemTap: ((Animal) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = AnimalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(items[position], onItemTap)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AnimalViewHolder(val binding: AnimalItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(animal: Animal, onItemTap: ((Animal) -> Unit)?) {
            binding.brief = AnimalBrief(animal.name, animal.disease)

            animal?.image?.let { url ->
                Glide.with(binding.root).load(url).centerCrop().placeholder(R.mipmap.ic_launcher).into(binding.animalImage)
            }

            binding.animalCard.setOnClickListener {
                onItemTap?.invoke(animal)
            }
        }
    }

    fun updateItems(newItems: ArrayList<Animal>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}