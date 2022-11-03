package com.inf5d6.tp1.ui.favorites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.inf5d6.tp1.models.DetailsTvShow
import com.inf5d6.tp1.repositories.FavoritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(val app: Application) : AndroidViewModel(app) {
    var tvShows: MutableLiveData<MutableList<DetailsTvShow>> = MutableLiveData(mutableListOf())
    val favRepo = FavoritesRepository(getApplication())

    fun getFavs() {
        viewModelScope.launch(Dispatchers.IO) {
            favRepo.getFavs(tvShows)
        }
    }
}
