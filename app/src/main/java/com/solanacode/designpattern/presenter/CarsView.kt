package com.solanacode.designpattern.presenter


import com.solanacode.designpattern.model.ResponseCarsItem

interface CarsView {
    fun onSucces(pesan : String, cars : List<ResponseCarsItem> )
    fun onError(pesan : String)
}