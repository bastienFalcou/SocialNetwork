package com.temporaryname.bastienfalcou.testnavigation.Helpers

import android.app.Activity
import android.app.AlertDialog
import android.widget.Toast
import com.github.kittinunf.fuel.core.FuelError

fun AlertDialog.Builder.show(error: FuelError, activity: Activity? = null, retryAction: (() -> Unit)? = null) {
    setTitle("Error")
    setMessage(error.localizedMessage)

    if (retryAction == null) {
        setPositiveButton("RETRY") { _, _ ->
            Toast.makeText(activity, "We are re-trying to fetch the movies.", Toast.LENGTH_SHORT).show()
            retryAction?.invoke()
        }
    }

    setNeutralButton("CANCEL") { _, _ ->
        Toast.makeText(activity,"Operation Cancelled.", Toast.LENGTH_SHORT).show()
    }

    val dialog = create()
    dialog.show()
}
