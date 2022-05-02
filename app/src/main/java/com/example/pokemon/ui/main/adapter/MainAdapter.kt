package com.example.pokemon.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.PokeItemBinding
import com.example.pokemon.model.data.result.PokemonResult

class MainAdapter( private var onListItemClickListener: OnListItemClickListener) : RecyclerView.Adapter<MainAdapter.ViewHolderItemPokemon>() {

    private var pokemonList : List<PokemonResult> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setNewList(list: List<PokemonResult>) {
        pokemonList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItemPokemon (
        PokeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolderItemPokemon, position: Int) {
        holder.bind(pokemonList[position])
    }

    override fun getItemCount() = pokemonList.size

    inner class ViewHolderItemPokemon(private val vb: PokeItemBinding) : RecyclerView.ViewHolder(vb.root) {

        fun bind(pokemonName: PokemonResult) {
            vb.pokemonName.text = pokemonName.name
            itemView.setOnClickListener{
                onListItemClickListener.onItemClick(pokemonName)
            }
        }
    }

    interface OnListItemClickListener {
        fun onItemClick(data: PokemonResult)
    }
}