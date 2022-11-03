package com.inf5d6.tp1.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.inf5d6.tp1.R
import com.inf5d6.tp1.models.DetailsTvShow
import com.squareup.picasso.Picasso

class HomeRvAdapter (private val tvshowList: MutableList<DetailsTvShow>):
    RecyclerView.Adapter<HomeRvAdapter.TvShowViewHolder>() {

    class TvShowViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tvshow_item, parent, false)
        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tvshowList.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val imgTvSHow = holder.view.findViewById<ImageView>(R.id.tvShowImg)
        val tvShowId = tvshowList[position].tvshowId
        Picasso.get().load(this.tvshowList[position].imgURL).into(imgTvSHow)
        imgTvSHow.setOnClickListener{
            val bundle = bundleOf(Pair("idTvShow", tvShowId))
            it.findNavController().navigate(R.id.navigation_details, bundle)
        }
    }

}