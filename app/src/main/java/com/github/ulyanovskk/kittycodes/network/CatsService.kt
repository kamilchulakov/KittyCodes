package com.github.ulyanovskk.kittycodes.network

import kotlinx.serialization.Serializable
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CatsService {
    @GET("{code}.jpg")
    fun getCat(@Path("code") code: String): CatResponse
}

@Serializable
data class CatResponse(
    val image: String
)