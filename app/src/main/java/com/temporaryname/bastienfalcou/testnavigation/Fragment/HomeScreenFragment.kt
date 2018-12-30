package com.temporaryname.bastienfalcou.testnavigation.Fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.temporaryname.bastienfalcou.testnavigation.R
import com.temporaryname.bastienfalcou.testnavigation.ViewModel.HomeScreenFragmentModel
import kotlinx.android.synthetic.main.fragment_home_screen.*
import com.temporaryname.bastienfalcou.testnavigation.Helpers.show

class HomeScreenFragment: Fragment() {
    private val viewModel = HomeScreenFragmentModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.moviesUpdate = { movies ->
            val listItems = movies.map { it.title }
            val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, listItems)
            moviesList.adapter = adapter
        }

        viewModel.errorReturned = { AlertDialog.Builder(context).show(it, activity) {
                viewModel.fetchMovies()
            }
        }

        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextView.text = arguments?.getString("nameArgument") ?: "Name Unspecified"

        viewModel.fetchMovies()
    }
}
