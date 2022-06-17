package com.example.pokemon.ui

import androidx.lifecycle.LiveData
import com.example.model.AppState
import com.example.model.result.PokemonResultData
import com.example.core.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val interactor: MainInteractor) : BaseViewModel<com.example.model.AppState>() {

    private val liveData: LiveData<com.example.model.AppState> = _mutableLiveData

    fun subscribe(): LiveData<com.example.model.AppState> {
        return liveData
    }

    override fun getData(isOnline: Boolean) {
        _mutableLiveData.value = com.example.model.AppState.Loading(0)
        viewModelCoroutineScope.launch { startInteractor(isOnline) }
    }

    override fun handlerError(error: Throwable) {
        _mutableLiveData.value = com.example.model.AppState.Error(error)
    }

    override fun onCleared() {
        _mutableLiveData.value = com.example.model.AppState.Success(
            com.example.model.result.PokemonResultData(
                listOf()
            )
        )
        super.onCleared()
    }

    private suspend fun startInteractor(isOnline:Boolean) {
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(interactor.getData(isOnline))
        }
    }
}