package com.example.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.model.AppState
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

    abstract fun getData(isOnline: Boolean)
    abstract fun handlerError(error: Throwable)
}