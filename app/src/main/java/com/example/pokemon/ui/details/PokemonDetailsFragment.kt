package com.example.pokemon.ui.details

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.pokemon.databinding.FragmentPokemonDetailsBinding
import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.details.DetailsPokemonData
import com.example.pokemon.model.data.result.PokemonResult
import com.example.pokemon.model.utils.isNetworkAvailable
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import org.koin.androidx.viewmodel.ext.android.viewModel


class PokemonDetailsFragment : Fragment() {

    private var fragmentBinding: FragmentPokemonDetailsBinding? = null
    private val binding get() = fragmentBinding!!
    private val viewModel: DetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentPokemonDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.subscribe().observe(viewLifecycleOwner) { renderData(it) }

        setArgumentInModel()
    }

    private fun setArgumentInModel() {
        viewModel.getData(isNetworkAvailable(requireContext()), getArgument().toString())
    }

    private fun getArgument(): String? {
        val data = arguments?.getSerializable(ARG_POKEMON) as PokemonResult
        return data.url?.takeLastWhile { !it.isLetter() }?.replace('/', ' ')?.trim()
    }

    private fun renderData(state: AppState) {
        when (state) {
            is AppState.Success -> {
                val data = state.data as DetailsPokemonData
                val pokemonImage = data.sprites.other.dream.frontDefault
                loadImage(pokemonImage)
            }
            is AppState.Loading -> {}

            is AppState.Error -> {
                println(state.error.message)
                Toast.makeText(requireContext(), state.error.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadImage(pokemonImage: String) {
        val requestBuilder: RequestBuilder<PictureDrawable> = initRequestBuilder()

        requestBuilder.load(Uri.parse(pokemonImage))
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(RequestOptions().centerCrop())
            .into(fragmentBinding!!.imagePokemon)
    }

    private fun initRequestBuilder(): RequestBuilder<PictureDrawable> {
        return GlideToVectorYou
            .init()
            .with(requireContext())
            .requestBuilder
    }

    companion object {
        private const val ARG_POKEMON = "POKEMON"

        @JvmStatic
        fun newInstance(pokemon: PokemonResult) =
            PokemonDetailsFragment().apply {
                arguments = bundleOf(ARG_POKEMON to pokemon)
            }
    }
}