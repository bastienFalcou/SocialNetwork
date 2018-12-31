package com.temporaryname.bastienfalcou.testnavigation.Fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.temporaryname.bastienfalcou.testnavigation.Adapter.MoviesAdapter
import com.temporaryname.bastienfalcou.testnavigation.Helpers.nullIfEmpty
import com.temporaryname.bastienfalcou.testnavigation.Helpers.show
import com.temporaryname.bastienfalcou.testnavigation.Model.Movie
import com.temporaryname.bastienfalcou.testnavigation.R
import com.temporaryname.bastienfalcou.testnavigation.ViewModel.HomeScreenFragmentModel
import kotlinx.android.synthetic.main.fragment_home_screen.*

class HomeScreenFragment: Fragment() {
    private val viewModel = HomeScreenFragmentModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.moviesUpdate = { moviesList.adapter = MoviesAdapter(context, it) }

        viewModel.errorReturned = { AlertDialog.Builder(context).show(it, activity) {
                viewModel.fetchMovies()
            }
        }

        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextView.text = arguments?.getString("nameArgument")?.nullIfEmpty() ?: "Name Unspecified"

        viewModel.fetchMovies()
    }

    private fun showMovieDetails(movie: Movie) {
        val bundle = Bundle()
        bundle.putSerializable("movieArgument", movie)
        findNavController().navigate(R.id.toMovieDetailsFragment, bundle)
    }
}
