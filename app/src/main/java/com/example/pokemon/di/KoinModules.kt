package com.example.pokemon.di

import androidx.room.Room
import com.example.detailsscreen.details.DetailsInteractor
import com.example.detailsscreen.details.DetailsViewModel
import com.example.model.details.DetailsPokemonData
import com.example.model.result.PokemonResultData
import com.example.pokemon.ui.MainInteractor
import com.example.pokemon.ui.MainViewModel
import com.example.repository.repository.datasourse.RetrofitImplementation
import com.example.repository.repository.datasourse.RoomDataBaseImplementation
import com.example.repository.repository.datasourse.details.local.DataSourceDetailsLocalImpl
import com.example.repository.repository.datasourse.details.local.DataSoursDetailsLocal
import com.example.repository.repository.datasourse.details.remote.DataSourceDetailsRemoteImpl
import com.example.repository.repository.datasourse.main.local.DataSourceLocalImpl
import com.example.repository.repository.datasourse.main.remote.DataSourceRemoteImpl
import com.example.repository.repository.repository.details.remote.RepositoryDetails
import com.example.repository.repository.repository.details.remote.RepositoryDetailsImplementation
import com.example.repository.repository.repository.main.local.RepositoryLocal
import com.example.repository.repository.repository.main.local.RepositoryLocalImplementation
import com.example.repository.repository.repository.main.remote.RepositoryMain
import com.example.repository.repository.repository.main.remote.RepositoryMainImplementation
import com.example.repository.repository.repository.room.HistoryDataBase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {
    single {
        Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB")
            .fallbackToDestructiveMigration()
            .build()
    }
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


