package com.inf5d6.tp1.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.inf5d6.tp1.R

import com.inf5d6.tp1.models.Season
import com.squareup.picasso.Picasso

class SeasonsRvAdapter (private val seasons : MutableList<Season>):
    RecyclerView.Adapter<SeasonsRvAdapter.SeasonsViewHolder>() {

    class SeasonsViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.season_item, parent, false)
        return SeasonsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeasonsViewHolder, position: Int) {

        val seasonNumber = holder.view.findViewById<TextView>(R.id.seasonNb)
        val episodes= holder.view.findViewById<TextView>(R.id.nbEpisode)
        val imgSeason = holder.view.findViewById<ImageView>(R.id.seasonImg)
        Picasso.get().load(this.seasons[position].imgURL).into(imgSeason)
        seasonNumber.append(this.seasons[position].number.toString())
        episodes.text = this.seasons[position].episodeCount.toString() + " Episodes"

    }


    override fun getItemCount(): Int {
        return seasons.size
    }

}