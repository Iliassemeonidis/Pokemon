package com.example.pokemon.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pokemon.R
import com.example.pokemon.databinding.MainFragmentBinding
import com.example.pokemon.model.data.AppState
import com.example.pokemon.model.data.result.PokemonResult
import com.example.pokemon.model.data.result.PokemonResultData
import com.example.pokemon.model.utils.isNetworkAvailable
import com.example.pokemon.ui.details.PokemonDetailsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var mainFragmentBinding: MainFragmentBinding? = null
    private val binding get() = mainFragmentBinding!!
    private lateinit var adapter: MainAdapter
    private val mainViewModel: MainViewModel by viewModel()

    private val onClick: MainAdapter.OnListItemClickListener =
        object : MainAdapter.OnListItemClickListener {
            override fun onItemClick(data: PokemonResult) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PokemonDetailsFragment.newInstance(data))
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        subscribeOnViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainFragmentBinding = null
    }

    private fun subscribeOnViewModel() {
        mainViewModel.subscribe().observe(viewLifecycleOwner) { renderData(it) }
        mainViewModel.getData(isNetworkAvailable(requireContext()))
    }

    private fun initAdapter() {
        adapter = MainAdapter(onClick)
        binding.pokemonList.adapter = adapter
    }

    private fun renderData(state: AppState) {
        when (state) {
            is AppState.Success -> {
                val data = state.data as PokemonResultData
                val pokemonResult = data.results ?: listOf()
                setItemsOnAdapter(pokemonResult)
            }
            is AppState.Loading -> {}

            is AppState.Error -> {
                println(state.error.message)
                Toast.makeText(requireContext(), state.error.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setItemsOnAdapter(result: List<PokemonResult>) {
        adapter.setNewList(result)
    }
}