package com.temporaryname.bastienfalcou.testnavigation.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.temporaryname.bastienfalcou.testnavigation.Model.Movie
import com.temporaryname.bastienfalcou.testnavigation.R

class MoviesAdapter(context: Context?,
                    private val dataSource: Array<Movie>): BaseAdapter() {
    private val inflater: LayoutInflater
            = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.sample_list_item_movie, parent, false)
        var movie = getItem(position) as Movie

        val titleTextView = rowView.findViewById(R.id.title_view) as TextView
        titleTextView.text = movie.title

        val imageView = rowView.findViewById(R.id.image_view) as ImageView
        imageView.setImageURI(null) // TODO: (Bastien) use Picasso to load image asynchronously

        return rowView
    }
}