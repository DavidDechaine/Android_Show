package com.inf5d6.tp1.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.inf5d6.tp1.models.DetailsTvShow
import com.inf5d6.tp1.models.IsFav
import com.inf5d6.tp1.repositories.DetailsRepository
import com.inf5d6.tp1.repositories.FavoritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsTvShowViewModel(val app: Application, id: Int) : AndroidViewModel(app) {
    var tvShowsDetails: MutableLiveData<DetailsTvShow> = MutableLiveData()
    var isFavorite: MutableLiveData<IsFav> = MutableLiveData()
    val favsRepo = FavoritesRepository(getApplication())
    init{
        viewModelScope.launch(Dispatchers.IO) {
            val detailsRepo = DetailsRepository(getApplication())
            detailsRepo.showsDetail(tvShowsDetails,id)
            favsRepo.checkFav(isFavorite,id)
        }
    }
    fun addFav(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            favsRepo.addFav(id)

        }
    }
    fun removeFav(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            favsRepo.deleteFav(id)
        }
    }
}