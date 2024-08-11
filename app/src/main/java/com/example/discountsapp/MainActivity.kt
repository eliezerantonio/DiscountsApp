package com.example.discountsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.discountsapp.Views.HomeView2
import com.example.discountsapp.Views.HomeView3
import com.example.discountsapp.ui.theme.DiscountsAppTheme
import com.example.discountsapp.viewModels.CalculateViewModel2
import com.example.discountsapp.viewModels.CalculateViewModel3

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: CalculateViewModel3 by viewModels()
        setContent {
            DiscountsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    HomeView3(viewModel = viewModel )
                }
            }
        }
    }
}
