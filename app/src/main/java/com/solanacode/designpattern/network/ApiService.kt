package com.solanacode.designpattern.network


import com.solanacode.designpattern.model.ResponseCarsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getAllCar() : Call<List<ResponseCarsItem>>
}