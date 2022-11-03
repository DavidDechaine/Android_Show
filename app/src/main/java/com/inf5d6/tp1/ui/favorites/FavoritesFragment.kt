package com.inf5d6.tp1.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inf5d6.tp1.R
import com.inf5d6.tp1.adaptors.HomeRvAdapter

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.favoritesViewModel =
            ViewModelProvider(this).get(FavoritesViewModel::class.java)
        val recyclerViewShows = view.findViewById<RecyclerView>(R.id.rvTvShows)
        recyclerViewShows.layoutManager = GridLayoutManager(this.context, 2)
        favoritesViewModel.getFavs()
        this.favoritesViewModel.tvShows.observe(viewLifecycleOwner){
            recyclerViewShows.adapter = HomeRvAdapter(it)
        }
    }
}