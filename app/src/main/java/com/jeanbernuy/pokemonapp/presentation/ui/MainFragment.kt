package com.jeanbernuy.pokemonapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.jeanbernuy.pokemonapp.core.Resource
import com.jeanbernuy.pokemonapp.data.model.Pokemon
import com.jeanbernuy.pokemonapp.databinding.FragmentMainBinding
import com.jeanbernuy.pokemonapp.formatPokemonName
import com.jeanbernuy.pokemonapp.presentation.viewmodels.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [MainFragment]
 * created by: Jean Bernuy
 */

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: PokemonViewModel by viewModels()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadPokemon()
    }

    private fun loadPokemon() {
        viewModel.loadPokemon.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    setupViews(result.data)
                    binding.progressBar.visibility = View.GONE
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error on server...", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setupViews(pokemon: Pokemon) {
        binding.pokemonName.text = formatPokemonName(pokemon.name)
        Glide.with(requireContext()).load(pokemon.sprites?.other?.home?.frontDefault)
            .into(binding.pokemonImage)
        binding.moreInfo.setOnClickListener {
            navigateToDetailFragment(pokemon)
        }
    }

    private fun navigateToDetailFragment(pokemon: Pokemon) {
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(pokemon)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}