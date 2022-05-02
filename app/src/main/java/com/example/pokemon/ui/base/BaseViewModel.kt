package com.example.pokemon.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemon.model.data.AppState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel<T : AppState>(
    protected open val _mutableLiveData: MutableLiveData<T> = MutableLiveData()
) :
    ViewModel() {

    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable -> handlerError(throwable) }
    )

    abstract fun getData()
    abstract fun handlerError(error: Throwable)
}