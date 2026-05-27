package com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.info

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.info.components.ProfileContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController){
    Scaffold(
        content = {
            ProfileContent(navController)
        },
    )
}