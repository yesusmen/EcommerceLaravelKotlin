package com.codeboss.ecommercelaravelkotlin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.codeboss.ecommercelaravelkotlin.presentation.navigation.graph.root.RooNavGraph
import com.codeboss.ecommercelaravelkotlin.presentation.ui.theme.EcommerceLaravelKotlinTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcommerceLaravelKotlinTheme {

                RooNavGraph()
            }
        }
    }
}

