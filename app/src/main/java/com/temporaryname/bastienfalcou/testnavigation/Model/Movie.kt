package com.temporaryname.bastienfalcou.testnavigation.Model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Movie(val id: String,
                 val owner: String,
                 val title: String,
                 val isPublic: Boolean,
                 var urlString: String) {
    class Deserializer: ResponseDeserializable<Array<Movie>> {
        override fun deserialize(content: String): Array<Movie>? = Gson().fromJson(content, Array<Movie>::class.java)
    }
}
