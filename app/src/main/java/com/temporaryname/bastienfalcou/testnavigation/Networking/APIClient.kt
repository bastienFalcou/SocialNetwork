package com.temporaryname.bastienfalcou.testnavigation.Networking

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.interceptors.cUrlLoggingRequestInterceptor
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.temporaryname.bastienfalcou.testnavigation.Model.Movie

private const val API_KEY = "946f7b3931c2d9b16795a35515da4c8b"
private const val EXTRAS = "url_sq"
private const val FORMAT = "json"
private const val TIMOUT_MILLISECONDS = 60000

object APIClient {
    init {
        FuelManager.instance.basePath = "https://api.flickr.com/services/rest"
        FuelManager.instance.baseHeaders = mapOf(
            "Accept" to "application/json",
            "Content-Type" to "application/json",
            "Accept-Encoding" to "identity"
        )
        FuelManager.instance.baseParams = listOf(
            "method" to "flickr.photos.search",
            "text" to "horror",
            "api_key" to API_KEY,
            "extras" to EXTRAS,
            "format" to FORMAT,
            "nojsoncallback" to 1
        )
        FuelManager.instance.addRequestInterceptor(cUrlLoggingRequestInterceptor())
        FuelManager.instance.timeoutInMillisecond = TIMOUT_MILLISECONDS
    }

    fun fetchMovies(completion: (String) -> Unit) {
        "/".httpGet().responseObject(Movie.Deserializer()) { _, _, result ->
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                    println("Error API: " + ex)
                }
                is Result.Success -> {
                    val data = result.get()
                    completion(data.toString())
                }
            }
        }
    }
}