package com.example.pokemon.di

import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.datasourse.RetrofitImplementation
import com.example.pokemon.model.datasourse.RoomDataBaseImplementation
import com.example.pokemon.model.repository.details.RepositoryDetails
import com.example.pokemon.model.repository.details.RepositoryDetailsImplementation
import com.example.pokemon.model.repository.main.Repository
import com.example.pokemon.model.repository.main.RepositoryImplementation
import com.example.pokemon.ui.details.DetailsInteractor
import com.example.pokemon.ui.details.DetailsViewModel
import com.example.pokemon.ui.main.MainInteractor
import com.example.pokemon.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {

    single<Repository<PokemonResultData>>(named(NAME_REMOTE)) {
        RepositoryImplementation (
            RetrofitImplementation()
        )
    }
    single<RepositoryDetails<DetailsPokemonData>>(named(NAME_REMOTE)) {
        RepositoryDetailsImplementation (
            RetrofitImplementation()
        )
    }
    single<Repository<PokemonResultData>>(named(NAME_LOCAL)) {
        RepositoryImplementation(
            RoomDataBaseImplementation()
        )
    }

    single<RepositoryDetails<DetailsPokemonData>>(named(NAME_LOCAL)) {
        RepositoryDetailsImplementation (
            RoomDataBaseImplementation()
        )
    }
}

val mainScreen = module {

    factory {
        MainInteractor(
            remoteRepository = get(named(NAME_REMOTE)),
            localRepository = get(named(NAME_LOCAL))
        )
    }
    factory {
        DetailsInteractor(
            remoteRepository = get(named(NAME_REMOTE)),
            localRepository = get(named(NAME_LOCAL))
        )
    }

    viewModel { MainViewModel(interactor = get()) }

    viewModel { DetailsViewModel(interactor = get()) }
}


