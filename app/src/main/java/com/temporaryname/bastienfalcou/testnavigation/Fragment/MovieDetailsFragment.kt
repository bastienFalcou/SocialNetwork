package com.temporaryname.bastienfalcou.testnavigation.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.temporaryname.bastienfalcou.testnavigation.Model.Movie
import com.temporaryname.bastienfalcou.testnavigation.ViewModel.MovieDetailsFragmentModel

class MovieDetailsFragment: Fragment() {
    private val viewModel = MovieDetailsFragmentModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movie = arguments?.getSerializable("movieArgument") as Movie
        viewModel.movie = movie
    }
}
