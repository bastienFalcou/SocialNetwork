package com.temporaryname.bastienfalcou.testnavigation.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.temporaryname.bastienfalcou.testnavigation.Model.Movie
import com.temporaryname.bastienfalcou.testnavigation.Networking.APIClient
import com.temporaryname.bastienfalcou.testnavigation.Networking.ModelAPI.fetchMovies
import com.temporaryname.bastienfalcou.testnavigation.R
import kotlinx.android.synthetic.main.fragment_home_screen.*

class HomeScreenFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextView.text = arguments?.getString("nameArgument")

        APIClient.start()
        Movie.fetchMovies { print(it) }
    }
}
