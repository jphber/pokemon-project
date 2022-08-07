package com.jeanbernuy.pokemonapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jeanbernuy.pokemonapp.core.Resource
import com.jeanbernuy.pokemonapp.data.remote.PokemonDataSource
import com.jeanbernuy.pokemonapp.data.repository.PokemonDataRepository
import com.jeanbernuy.pokemonapp.databinding.FragmentMainBinding
import com.jeanbernuy.pokemonapp.presentation.viewmodels.PokemonViewModel
import com.jeanbernuy.pokemonapp.presentation.viewmodels.VMFactory

/**
 * A simple [MainFragment]
 * created by: Jean Bernuy
 */
class MainFragment : Fragment() {

    private val viewModel by viewModels<PokemonViewModel> {
        VMFactory(PokemonDataRepository(PokemonDataSource()))
    }

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
                    Toast.makeText(requireContext(), "Loading.....", Toast.LENGTH_LONG).show()
                }
                is Resource.Success -> {
                    Toast.makeText(requireContext(), "${result.data}", Toast.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Error on server...", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}