package com.inf5d6.tp1.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.inf5d6.tp1.models.DetailsTvShow
import com.inf5d6.tp1.repositories.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(val app: Application) : AndroidViewModel(app) {
    var tvShows : MutableLiveData<MutableList<DetailsTvShow>> = MutableLiveData(mutableListOf())
    init{
        viewModelScope.launch(Dispatchers.IO) {
            val homeRepo = HomeRepository(getApplication())
            homeRepo.loadTvshows(tvShows)
        }
    }
}