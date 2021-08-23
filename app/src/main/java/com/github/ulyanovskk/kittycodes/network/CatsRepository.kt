package com.github.ulyanovskk.kittycodes.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatsRepository(
    private val catsService: CatsService,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getCat(code: String): CatResponse = withContext(defaultDispatcher){
        catsService.getCat(code)
    }

}
