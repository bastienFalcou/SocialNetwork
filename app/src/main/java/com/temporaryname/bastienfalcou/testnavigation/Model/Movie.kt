package com.temporaryname.bastienfalcou.testnavigation.Model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.JSONObject

data class Movie(val id: String,
                 val owner: String,
                 val title: String,
                 val isPublic: Boolean,
                 var urlString: String) {
    companion object {}

    class Deserializer: ResponseDeserializable<Array<Movie>> {
        override fun deserialize(content: String): Array<Movie>? {
            val json = JSONObject(content)
                .getJSONObject("photos")
                .getJSONArray("photo")
                .toString()
            return Gson().fromJson(json, Array<Movie>::class.java)
        }
    }
}
