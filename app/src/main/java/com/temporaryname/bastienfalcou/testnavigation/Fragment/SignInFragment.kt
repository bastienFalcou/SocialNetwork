package com.temporaryname.bastienfalcou.testnavigation.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.temporaryname.bastienfalcou.testnavigation.R
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment: Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextButton.setOnClickListener {
            var nameBundle = Bundle()
            nameBundle.putString("nameArgument", emailText.text.toString())
            it.findNavController().navigate(R.id.toHomeScreenFragment, nameBundle)
        }
    }
}
