package com.codeboss.ecommercelaravelkotlin.domain.util

import com.codeboss.ecommercelaravelkotlin.domain.model.ErrorResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import okhttp3.ResponseBody

object ConvertErrorBody {

    private val moshi = Moshi.Builder().build()
    private val adapter: JsonAdapter<ErrorResponse> = moshi.adapter(ErrorResponse::class.java)

    fun convert(errorBody: ResponseBody?): ErrorResponse? {
        return try {

            errorBody?.source()?.let {
               adapter.fromJson(errorBody.source())
            }

        } catch (e: Exception) {
            null
        }
    }
}