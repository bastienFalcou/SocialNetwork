package com.temporaryname.bastienfalcou.testnavigation

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.interceptors.cUrlLoggingRequestInterceptor
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

object APIClient {
    init {
        FuelManager.instance.basePath = "https://api.flickr.com/services/rest"
        FuelManager.instance.addRequestInterceptor(cUrlLoggingRequestInterceptor())
        FuelManager.instance.timeoutInMillisecond = 60000
        FuelManager.instance.baseParams = listOf(
            "api_key" to "946f7b3931c2d9b16795a35515da4c8b",
            "extras" to "url_sq",
            "format" to "json",
            "nojsoncallback" to 1
        )
    }

    fun fetchMovies(completion: (String) -> Unit) {
        val bodyJson = """
        {
            "method": "flickr.photos.search",
            "text": "horror",
        }
        """

        "".httpGet()
            .body(bodyJson)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        println("Error API: " + ex)
                    }
                    is Result.Success -> {
                        val data = result.get()
                        completion(data)
                    }
                }
        }
    }
}