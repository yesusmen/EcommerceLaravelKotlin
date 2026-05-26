package com.codeboss.ecommercelaravelkotlin.presentation.screens.client.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.codeboss.ecommercelaravelkotlin.presentation.screens.client.product.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen(){
    Scaffold(
        topBar = {},
        content = {paddingValues ->
            ClientProductListContent(paddingValues)
        },
        bottomBar = {},
    )
}