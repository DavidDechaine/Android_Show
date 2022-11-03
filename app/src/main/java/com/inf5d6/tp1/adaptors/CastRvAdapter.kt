package com.inf5d6.tp1.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.inf5d6.tp1.R
import com.inf5d6.tp1.models.Role
import com.squareup.picasso.Picasso

class CastRvAdapter (private val cast : MutableList<Role>):
    RecyclerView.Adapter<CastRvAdapter.CastViewHolder>() {

    class CastViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cast_item, parent, false)
        return CastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cast.size
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val imgCast = holder.view.findViewById<ImageView>(R.id.seasonImg)
        val castName = holder.view.findViewById<TextView>(R.id.seasonNb)
        val castRole = holder.view.findViewById<TextView>(R.id.nbEpisode)
        Picasso.get().load(this.cast[position].imgURL).into(imgCast)
        castName.text = this.cast[position].name
        castRole.text = this.cast[position].character
    }
}