package com.github.ulyanovskk.kittycodes.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InternetCodesViewModel() : ViewModel() {
    private val _catUrl = MutableStateFlow("https://http.cat/404.jpg")
    val catUrl: StateFlow<String> = _catUrl
    private val basicUrl: String = "https://http.cat/"
    private val imageType = ".jpg"

    fun setCatUrl(code: String) {
        _catUrl.value = basicUrl + code + imageType
    }
}