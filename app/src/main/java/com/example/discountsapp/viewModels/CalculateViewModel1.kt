package com.example.discountsapp.viewModels

import androidx.lifecycle.ViewModel

class CalculateViewModel1 : ViewModel() {

    fun calcular(price: String, discount: String): Pair<Double, Pair<Double, Boolean>>{

        var discountPrice = 0.0
        var totalDiscount = 0.0
        var showAlert = false

        if (price != "" && discount != "") {
            discountPrice = calculatePrice(price.toDouble(), discount.toDouble())
            totalDiscount = calculateDiscount(price.toDouble(), discount.toDouble())
        } else {
            showAlert = true
        }


        return Pair(discountPrice, Pair(totalDiscount, showAlert))
    }

    private fun calculatePrice(price: Double, discount: Double): Double {

        val res = price - calculateDiscount(price, discount)

        return kotlin.math.round(res * 100) / 100.0

    }

    private fun calculateDiscount(price: Double, discount: Double): Double {

        val res = price * (1 - discount / 1000)

        return kotlin.math.round(res * 100) / 100.0

    }

}