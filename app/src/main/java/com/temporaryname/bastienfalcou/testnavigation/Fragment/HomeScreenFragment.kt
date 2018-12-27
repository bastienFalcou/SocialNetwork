package com.temporaryname.bastienfalcou.testnavigation.Fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.temporaryname.bastienfalcou.testnavigation.R
import com.temporaryname.bastienfalcou.testnavigation.ViewModel.HomeScreenFragmentModel
import kotlinx.android.synthetic.main.fragment_home_screen.*

class HomeScreenFragment: Fragment() {
    private val viewModel = HomeScreenFragmentModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.moviesUpdate = {
            val builder = AlertDialog.Builder(context)

            builder.setTitle("Error")
            builder.setMessage(it.toString())

            builder.setPositiveButton("RETRY") { _, _ ->
                Toast.makeText(activity,"We are re-trying to fetch the movies.", Toast.LENGTH_SHORT).show()
                viewModel.fetchMovies()
            }

            builder.setNeutralButton("Cancel") { _, _ ->
                Toast.makeText(activity,"Operation Cancelled.", Toast.LENGTH_SHORT).show()
            }

            val dialog = builder.create()
            dialog.show()
        }

        viewModel.errorReturned = { println(it.localizedMessage) }

        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextView.text = arguments?.getString("nameArgument")

        viewModel.fetchMovies()
    }
}
