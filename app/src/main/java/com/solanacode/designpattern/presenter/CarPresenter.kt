package com.solanacode.designpattern.presenter

import com.solanacode.designpattern.model.ResponseCarsItem
import com.solanacode.designpattern.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarPresenter(val viewCar : CarsView) {
    fun getDataCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<ResponseCarsItem>> {
                override fun onResponse(
                    call: Call<List<ResponseCarsItem>>,
                    response: Response<List<ResponseCarsItem>>
                ) {
                    if (response.isSuccessful){
                        viewCar.onSucces(response.message(), response.body()!!)
                    }else{
                        viewCar.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<ResponseCarsItem>>, t: Throwable) {
                    viewCar.onError(t.message!!)
                }

            })
    }
}