package com.example.discountsapp.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.discountsapp.model.CalculateState

class CalculateViewModel3 : ViewModel() {

    var state by mutableStateOf(CalculateState())
        private set


    fun onValue(value: String, text: String) {
        when (text) {

            "price" -> state = state.copy(price = value)
            "discount" -> state = state.copy(discount = value)
        }
    }


    fun calculate() {
        val price = state.price
        val discount = state.discount

        state = if (price != "" && discount != "") {
            state.copy(
                discountPrice = calculatePrice(price.toDouble(), discount.toDouble()),
                discountTotal = calculateDiscount(price.toDouble(), discount.toDouble())
            )

        } else {
            state.copy(showAlert = false)
        }
    }


    private fun calculatePrice(price: Double, discount: Double): Double {

        val res = price - calculateDiscount(price, discount)

        return kotlin.math.round(res * 100) / 100.0

    }

    private fun calculateDiscount(price: Double, discount: Double): Double {

        val res = price * (1 - discount / 100)

        return kotlin.math.round(res * 100) / 100.0

    }

    fun clear() {

        state = state.copy(price = "", discount = "", discountPrice = 0.0, discountTotal = 0.0)


    }

    fun cancelAlert() {
        state = state.copy(showAlert = false)
    }

}