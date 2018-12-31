package com.temporaryname.bastienfalcou.testnavigation.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.temporaryname.bastienfalcou.testnavigation.R
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextButton.setOnClickListener {
            var nameBundle = Bundle()
            nameBundle.putString("nameArgument", emailText.text.toString())
            it.findNavController().navigate(R.id.toHomeScreenFragment, nameBundle)
        }
    }
}
