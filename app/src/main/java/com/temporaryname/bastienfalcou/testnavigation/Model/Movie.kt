package com.temporaryname.bastienfalcou.testnavigation.Model

import android.os.Build
import android.support.annotation.RequiresApi
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.JSONObject
import java.io.Serializable

data class Movie(val id: String,
                 val owner: String,
                 val title: String,
                 val isPublic: Boolean,
                 val imageUrl: String,
                 val imageHeight: Int,
                 val imageWidth: Int): Serializable {
    companion object {
        val parser = mapOf(
            "url_sq" to "imageUrl",
            "height_sq" to "imageHeight",
            "width_sq" to "imageWidth"
        )
    }

    class Deserializer: ResponseDeserializable<Array<Movie>> {
        @RequiresApi(Build.VERSION_CODES.N)
        override fun deserialize(content: String): Array<Movie>? {
            var jsonString = JSONObject(content)
                .getJSONObject("photos")
                .getJSONArray("photo")
                .toString()
            Movie.parser.forEach { key, value -> jsonString = jsonString.replace(key, value) }
            return Gson().fromJson(jsonString, Array<Movie>::class.java)
        }
    }
}
