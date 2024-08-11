package com.example.discountsapp.model

data class CalculateState(

    val price: String = "",
    val discount: String = "",
    val discountPrice: Double = 0.0,
    val discountTotal: Double = 0.0,
    val showAlert: Boolean = false


)