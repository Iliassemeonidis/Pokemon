package com.example.pokemon.di

import androidx.room.Room
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.RetrofitImplementation
import com.example.pokemon.model.datasourse.RoomDataBaseImplementation
import com.example.pokemon.model.datasourse.main.DataSourceRemote
import com.example.pokemon.model.repository.details.RepositoryDetails
import com.example.pokemon.model.repository.details.RepositoryDetailsImplementation
import com.example.pokemon.model.repository.main.RepositoryMain
import com.example.pokemon.model.repository.main.RepositoryMainImplementation
import com.example.pokemon.model.repository.room.HistoryDataBase
import com.example.pokemon.ui.details.DetailsInteractor
import com.example.pokemon.ui.details.DetailsViewModel
import com.example.pokemon.ui.main.MainInteractor
import com.example.pokemon.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(),HistoryDataBase::class.java,"HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
}

val mainScreen = module {

    factory {
        MainInteractor(
            remoteRepository = get(named(NAME_REMOTE)),
            localRepository = get(named(NAME_LOCAL))
        )
    }

    factory<RepositoryMain<PokemonResultData>>(named(NAME_REMOTE)) {
        RepositoryMainImplementation(
            DataSourceRemote(RetrofitImplementation())
        )
    }

    factory<RepositoryMain<PokemonResultData>>(named(NAME_LOCAL)) {
        RepositoryMainImplementation(
            RoomDataBaseImplementation(get())
        )
    }

    viewModel { MainViewModel(interactor = get()) }
}

val detailsScreen = module {

    factory {
        DetailsInteractor(
            remoteRepository = get(named(NAME_REMOTE)),
            localRepository = get(named(NAME_LOCAL))
        )
    }

    factory<RepositoryDetails<DetailsPokemonData>>(named(NAME_REMOTE)) {
        RepositoryDetailsImplementation(
            RoomDataBaseImplementation(get())
        )
    }

    factory<RepositoryDetails<DetailsPokemonData>>(named(NAME_LOCAL)) {
        RepositoryDetailsImplementation(
            RoomDataBaseImplementation(get())
        )
    }

    viewModel { DetailsViewModel(interactor = get()) }
}


