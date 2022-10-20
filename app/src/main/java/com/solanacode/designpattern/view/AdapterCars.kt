package com.solanacode.designpattern.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.solanacode.designpattern.databinding.ItemCarBinding
import com.solanacode.designpattern.model.ResponseCarsItem

class AdapterCars(var listCar : List<ResponseCarsItem>): RecyclerView.Adapter<AdapterCars.CarsViewHolder>() {
    inner class CarsViewHolder(var binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResponseCarsItem){
            binding.apply {
                nameCar.text = item.name
                categoryCar.text = item.category
                priceCar.text = item.price.toString()

                Glide.with(itemView).load(item.image).into(imgCar)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        var view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bind(listCar[position])
    }

    override fun getItemCount(): Int {
        return listCar.size
    }
    interface CarAdapterInterface {
        fun onItemClick(car : ResponseCarsItem)
    }

}