package com.example.discountsapp.Views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.example.discountsapp.components.*

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {


    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text("App Discounts", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {

        ContentHomeView(paddingValues = PaddingValues())
    }

}


@Composable
fun ContentHomeView(paddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var price by remember { mutableStateOf("") }
        var discount by remember { mutableStateOf("") }
        var discountPrice by remember { mutableDoubleStateOf(0.0) }
        var totalDiscount by remember { mutableDoubleStateOf(0.0) }
        var showAlert by remember { mutableStateOf(false) }
        TwoCards(
            title = "Total",
            number = totalDiscount,
            title2 = "Discount",
            number2 = discountPrice
        )

        MainTextField(value = price, onValueChange = { price = it }, label = "Price")
        VerticalSpacer()
        MainTextField(value = discount, onValueChange = { discount = it }, label = "Discount %")
        VerticalSpacer(10.dp)
        MainButton(text = "Generate Discount") {

            if (price != "" && discount != "") {
                discountPrice = calculatePrice(price.toDouble(), discount.toDouble())
                totalDiscount = calculateDiscount(price.toDouble(), discount.toDouble())
            } else {
                showAlert = true
            }


        }
        VerticalSpacer()
        MainButton(text = "Clear", color = Color.Red) {
            price = ""
            discount = ""
            discountPrice = 0.0
            totalDiscount = 0.0
        }

        if (showAlert) {
            Alert(
                title = "Alert",
                message = "All field are required",
                confirmText = "Accept",
                onConfirmClick = { showAlert = false }) {

            }
        }

    }

}

fun calculatePrice(price: Double, discount: Double): Double {

    val res = price - calculateDiscount(price, discount)

    return kotlin.math.round(res * 100) / 100.0

}

fun calculateDiscount(price: Double, discount: Double): Double {

    val res = price * (1 - discount / 1000)

    return kotlin.math.round(res * 100) / 100.0


}