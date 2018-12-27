package com.temporaryname.bastienfalcou.testnavigation.ViewModel

import com.github.kittinunf.fuel.core.FuelError
import com.temporaryname.bastienfalcou.testnavigation.Model.Movie
import com.temporaryname.bastienfalcou.testnavigation.Networking.ModelAPI.fetchMovies

class HomeScreenFragmentModel {
    var moviesUpdate: ((Array<Movie>) -> Unit)? = null
    var errorReturned: ((FuelError) -> Unit)? = null

    fun fetchMovies() {
        Movie.fetchMovies { movies, error ->
            if (movies != null) {
                moviesUpdate?.invoke(movies)
            }
            if (error != null) {
                errorReturned?.invoke(error)
            }
        }
    }
}
