package com.codeboss.ecommercelaravelkotlin.presentation.screens.profile

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.codeboss.ecommercelaravelkotlin.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen(){
    Scaffold(
        topBar = {},
        content = {paddingValues ->
            ProfileContent(paddingValues)
        },
        bottomBar = {}
    )
}