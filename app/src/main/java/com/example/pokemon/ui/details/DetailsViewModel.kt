package com.example.pokemon.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.model.data.AppState
import kotlinx.coroutines.*

class DetailsViewModel(private val interactor: DetailsInteractor) : ViewModel() {

    private val _mutableLiveData: MutableLiveData<AppState> = MutableLiveData()

    private val liveDataToObserver = _mutableLiveData

    fun subscribe(): LiveData<AppState> {
        return liveDataToObserver
    }

    fun getData(isOnline: Boolean, url: String) {
        _mutableLiveData.value = AppState.Loading(0)
        viewModelScope.launch(Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable -> handlerError(throwable) }
        ) { startInteractor(isOnline, url) }
    }

    private fun handlerError(error: Throwable) {
        _mutableLiveData.value = AppState.Error(error)
    }

    private suspend fun startInteractor(isOnline: Boolean, url: String) {
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(interactor.getImagePokemon(isOnline, url))
        }
    }
}