package com.temporaryname.bastienfalcou.testnavigation.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.temporaryname.bastienfalcou.testnavigation.R
import com.temporaryname.bastienfalcou.testnavigation.ViewModel.HomeScreenFragmentModel
import kotlinx.android.synthetic.main.fragment_home_screen.*

class HomeScreenFragment: Fragment() {
    private val viewModel = HomeScreenFragmentModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.moviesUpdate = { println(it) }
        viewModel.errorReturned = { println(it.localizedMessage) }

        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextView.text = arguments?.getString("nameArgument")

        viewModel.fetchMovies()
    }
}
