package com.codeboss.ecommercelaravelkotlin.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    val message: String = "",
    val status: Int = 500
)
