package com.rgp.primerproyecto.ejercicio_tres

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rgp.primerproyecto.R
import com.rgp.primerproyecto.ejercicio_dos.RecyclerAnimalListener


class AnimalsAdapter(
    private val animals: ArrayList<AnimalSQLModel>,
    private val listener: RecyclerDBAnimalListener,
    private val context: Context
) : RecyclerView.Adapter<AnimalsAdapter.AnimalsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalsViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.db_animal_item, parent, false)
        return AnimalsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalsViewHolder, position: Int) {
        holder.initFrom(animals[position], context)
        holder.animalCard.setOnClickListener {
            listener.onAnimalSelected(animals[position])
        }
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    class AnimalsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val image: ImageView
        val animalCard: CardView

        init {
            name = view.findViewById(R.id.tvAnimalName)
            image = view.findViewById(R.id.ivAnimalImage)
            animalCard = view.findViewById(R.id.cvAnimal)
        }

        fun initFrom(animal: AnimalSQLModel, context: Context) {
            name.text = animal.name
            Glide
                .with(context)
                .load(animal.image)
                .placeholder(R.drawable.ic_broken_image)
                .centerCrop()
                .into(image)
        }
    }
}