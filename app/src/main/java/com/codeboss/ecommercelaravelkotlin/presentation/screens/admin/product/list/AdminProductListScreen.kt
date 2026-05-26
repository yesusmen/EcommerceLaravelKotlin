package com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.codeboss.ecommercelaravelkotlin.presentation.screens.admin.product.list.components.AdminProductListContent


@Composable
fun AdminProductListScreen() {
    Scaffold(
        topBar = {},
        content = {paddingValues ->
            AdminProductListContent(paddingValues = paddingValues)
        },
        bottomBar = {},
    )
}