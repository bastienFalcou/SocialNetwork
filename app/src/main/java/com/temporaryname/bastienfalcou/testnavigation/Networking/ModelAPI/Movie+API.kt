package com.temporaryname.bastienfalcou.testnavigation.Networking.ModelAPI

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.temporaryname.bastienfalcou.testnavigation.Model.Movie

fun Movie.Companion.fetchMovies(completion: (Array<Movie>?, FuelError?) -> Unit) {
    "/".httpGet().responseObject(Movie.Deserializer()) { _, _, result: Result<Array<Movie>, FuelError> ->
        completion(result.component1(), result.component2())
    }
}
