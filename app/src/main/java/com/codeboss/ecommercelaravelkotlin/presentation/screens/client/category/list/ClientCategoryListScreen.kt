package com.codeboss.ecommercelaravelkotlin.presentation.screens.client.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.codeboss.ecommercelaravelkotlin.presentation.screens.client.category.list.components.ClientCategoryListContent

@Composable
fun ClientCategoryListScreen(){
    Scaffold(
        topBar = {},
        content = {paddingValues ->
            ClientCategoryListContent(paddingValues)
        },
        bottomBar = {}
    )
}