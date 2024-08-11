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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.example.discountsapp.components.*
import com.example.discountsapp.viewModels.CalculateViewModel2

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView2(viewModel: CalculateViewModel2) {


    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text("App Discounts", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {

        ContentHomeView2(paddingValues = PaddingValues(), viewModel)
    }

}


@Composable
fun ContentHomeView2(paddingValues: PaddingValues, viewModel: CalculateViewModel2) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TwoCards(
            title = "Total",
            number = viewModel.totalDiscount,
            title2 = "Discount",
            number2 = viewModel.discountPrice
        )

        MainTextField(
            value = viewModel.price,
            onValueChange = { viewModel.onValue(it, "price") },
            label = "Price"
        )
        VerticalSpacer()
        MainTextField(
            value = viewModel.discount,
            onValueChange = { viewModel.onValue(it, "discount") },
            label = "Discount %"
        )

        VerticalSpacer(10.dp)
        MainButton(text = "Generate Discount") {
            viewModel.calcular()

        }
        VerticalSpacer()
        MainButton(text = "Clear", color = Color.Red) {

            viewModel.clear()
        }

        if (viewModel.showAlert) {
            Alert(
                title = "Alert",
                message = "All field are required",
                confirmText = "Accept",
                onConfirmClick = { viewModel.cancelAlert() }) {

            }
        }

    }

}
