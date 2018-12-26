package com.temporaryname.bastienfalcou.testnavigation.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.temporaryname.bastienfalcou.testnavigation.Networking.APIClient
import com.temporaryname.bastienfalcou.testnavigation.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        APIClient.start()

        signUpButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toSignUpFragment)) // Version 1
        signInButton.setOnClickListener { it.findNavController().navigate(R.id.toSignInFragment) } // Version 2
    }
}
