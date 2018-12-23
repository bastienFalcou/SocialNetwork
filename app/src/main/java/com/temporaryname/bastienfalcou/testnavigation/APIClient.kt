package com.temporaryname.bastienfalcou.testnavigation

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

object APIClient {
    init {
        println("Some initialization")
    }

    fun fetchMovies(completion: (String) -> Unit) {
        "https://api.flickr.com/services/rest/flickr.photos.search"
            .httpGet()
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