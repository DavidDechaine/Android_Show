package com.inf5d6.tp1.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inf5d6.tp1.R
import com.inf5d6.tp1.adaptors.CastRvAdapter
import com.inf5d6.tp1.adaptors.SeasonsRvAdapter
import com.inf5d6.tp1.models.IsFav
import com.inf5d6.tp1.models.Role
import com.inf5d6.tp1.models.Season
import com.squareup.picasso.Picasso

class DetailsTvShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //On vient chercher le id de la série
        val showId = this.requireArguments().getInt("idTvShow")
        val btnFav = view.findViewById<ImageButton>(R.id.btnFavorite)
        val detailsTvShowModelFactory =
            DetailsTvShowModelFactory(application = requireActivity().application,showId)

        val tvShowViewModel = ViewModelProvider(
            this, detailsTvShowModelFactory).get(DetailsTvShowViewModel::class.java)

        tvShowViewModel.tvShowsDetails.observe(viewLifecycleOwner){
            val recyclerViewCast = view.findViewById<RecyclerView>(R.id.rvCast)
            recyclerViewCast.layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewCast.adapter = CastRvAdapter(it.roles as MutableList<Role>)

            val recyclerViewSeasons = view.findViewById<RecyclerView>(R.id.rvSeasons)
            recyclerViewSeasons.layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewSeasons.adapter = SeasonsRvAdapter(it.seasons as MutableList<Season>)

            view.findViewById<TextView>(R.id.tvShowTitle).text = it.title
            view.findViewById<TextView>(R.id.tvShowYear).text = it.year.toString()
            view.findViewById<TextView>(R.id.tvShowDescription).text = it.plot
            view.findViewById<TextView>(R.id.tvShowNbEpisodes).text = it.episodeCount.toString() + " Episodes"
            val img = view.findViewById<ImageView>(R.id.tvShowImgDetails)
            Picasso.get().load(it.imgURL).into(img)

        }

        tvShowViewModel.isFavorite.observe(viewLifecycleOwner){

            if (it.isFavorite){
                btnFav.setImageResource(android.R.drawable.btn_star_big_on)
                btnFav.tag = "on"
            }else{
                btnFav.setImageResource(android.R.drawable.btn_star_big_off)
                btnFav.tag = "off"
            }
            btnFav.setOnClickListener {
                if (btnFav.tag == "on"){
                    tvShowViewModel.removeFav(showId)
                    tvShowViewModel.isFavorite.value = IsFav(false)
                }else{
                    tvShowViewModel.addFav(showId)
                    tvShowViewModel.isFavorite.value = IsFav(true)
                }
            }

        }



    }

}