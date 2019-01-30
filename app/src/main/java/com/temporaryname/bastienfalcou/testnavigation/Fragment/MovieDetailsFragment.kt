package com.temporaryname.bastienfalcou.testnavigation.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.temporaryname.bastienfalcou.testnavigation.Model.Movie
import com.temporaryname.bastienfalcou.testnavigation.R
import com.temporaryname.bastienfalcou.testnavigation.ViewModel.MovieDetailsFragmentModel
import kotlinx.android.synthetic.main.fragment_movie_details.*

class MovieDetailsFragment: Fragment() {
    private val viewModel = MovieDetailsFragmentModel()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val movie = arguments?.getSerializable("movieArgument") as Movie
        viewModel.movie = movie

        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleTextView.text = viewModel.movie?.title

        val movie = viewModel.movie
        if (movie != null) {
            Picasso.get()
                .load(movie.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView)
        }
    }
}
