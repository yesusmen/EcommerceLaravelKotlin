package com.codeboss.ecommercelaravelkotlin.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.components.ProfileContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(){
    Scaffold(
        content = {
            ProfileContent()
        },
    )
}