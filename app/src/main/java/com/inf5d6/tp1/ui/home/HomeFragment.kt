package com.inf5d6.tp1.ui.home

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

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val recyclerViewShows = view.findViewById<RecyclerView>(R.id.rvTvShows)
        recyclerViewShows.layoutManager = GridLayoutManager(this.context, 2)
        this.homeViewModel.tvShows.observe(viewLifecycleOwner){
            recyclerViewShows.adapter = HomeRvAdapter(it)
        }
    }
}