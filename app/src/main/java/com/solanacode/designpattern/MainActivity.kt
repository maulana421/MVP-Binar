package com.solanacode.designpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.solanacode.designpattern.databinding.ActivityMainBinding
import com.solanacode.designpattern.model.ResponseCarsItem
import com.solanacode.designpattern.presenter.CarPresenter
import com.solanacode.designpattern.presenter.CarsView
import com.solanacode.designpattern.view.AdapterCars

class MainActivity : AppCompatActivity(), CarsView {
    private lateinit var binding: ActivityMainBinding
    lateinit var carPresenter: CarPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carPresenter = CarPresenter(this)
        carPresenter.getDataCar()

    }

    override fun onSucces(pesan: String, cars: List<ResponseCarsItem>) {
        binding.apply {
            rvCar.layoutManager = LinearLayoutManager(this@MainActivity)
            rvCar.adapter = AdapterCars(cars)
        }
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, "eror", Toast.LENGTH_SHORT).show()
    }


}