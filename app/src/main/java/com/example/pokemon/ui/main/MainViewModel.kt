package com.example.pokemon.ui.main

import androidx.lifecycle.LiveData
import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val interactor: MainInteractor) : BaseViewModel<AppState>() {

    private val liveData: LiveData<AppState> = _mutableLiveData

    fun subscribe(): LiveData<AppState> {
        return liveData
    }

    override fun getData(isOnline: Boolean) {
        _mutableLiveData.value = AppState.Loading(0)
        viewModelCoroutineScope.launch { startInteractor(isOnline) }
    }

    override fun handlerError(error: Throwable) {
        _mutableLiveData.value = AppState.Error(error)
    }

    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(PokemonResultData(listOf()))
        super.onCleared()
    }

    private suspend fun startInteractor(isOnline:Boolean) {
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(interactor.getData(isOnline))
        }
    }
}