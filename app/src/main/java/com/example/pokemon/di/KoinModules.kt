package com.example.pokemon.di

import androidx.room.Room
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.RetrofitImplementation
import com.example.pokemon.model.datasourse.RoomDataBaseImplementation
import com.example.pokemon.model.datasourse.details.local.DataSourceDetailsLocalImpl
import com.example.pokemon.model.datasourse.details.local.DataSoursDetailsLocal
import com.example.pokemon.model.datasourse.details.remote.DataSourceDetailsRemoteImpl
import com.example.pokemon.model.datasourse.main.local.DataSourceLocalImpl
import com.example.pokemon.model.datasourse.main.remote.DataSourceRemoteImpl
import com.example.pokemon.model.repository.details.remote.RepositoryDetails
import com.example.pokemon.model.repository.details.remote.RepositoryDetailsImplementation
import com.example.pokemon.model.repository.main.local.RepositoryLocal
import com.example.pokemon.model.repository.main.local.RepositoryLocalImplementation
import com.example.pokemon.model.repository.main.remote.RepositoryMain
import com.example.pokemon.model.repository.main.remote.RepositoryMainImplementation
import com.example.pokemon.model.repository.room.HistoryDataBase
import com.example.pokemon.ui.details.DetailsInteractor
import com.example.pokemon.ui.details.DetailsViewModel
import com.example.pokemon.ui.main.MainInteractor
import com.example.pokemon.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
}

val mainScreen = module {

    factory { MainInteractor(repository = get()) }

    factory<RepositoryMain<PokemonResultData>> {
        RepositoryMainImplementation(
            DataSourceRemoteImpl(RetrofitImplementation(), RoomDataBaseImplementation(get())),
            DataSourceLocalImpl(RoomDataBaseImplementation(get())),
        )
    }

    factory<RepositoryDetails<DetailsPokemonData>> {
        RepositoryDetailsImplementation(
            DataSourceDetailsLocalImpl(RoomDataBaseImplementation(get())),
            DataSourceDetailsRemoteImpl(RetrofitImplementation(), RoomDataBaseImplementation(get()))
        )
    }

    factory<RepositoryLocal<PokemonResultData>> {
        RepositoryLocalImplementation(DataSourceLocalImpl(get()))
    }

    factory<DataSoursDetailsLocal<DetailsPokemonData>> {
        DataSourceDetailsLocalImpl(RoomDataBaseImplementation(get()))
    }

    viewModel { MainViewModel(interactor = get()) }
}

val detailsScreen = module {
    factory { DetailsInteractor(remoteRepository = get()) }
    viewModel { DetailsViewModel(interactor = get()) }
}


