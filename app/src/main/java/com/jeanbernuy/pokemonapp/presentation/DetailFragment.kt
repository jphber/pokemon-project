package com.jeanbernuy.pokemonapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jeanbernuy.pokemonapp.databinding.FragmentDetailBinding


/**
 * A simple [DetailFragment]
 *
 */
class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        with(binding) {
            Glide.with(requireContext()).load(args.pokemon.sprites?.other?.home?.frontDefault)
                .into(pokemonImage)
            with(args) {
                pokemonType1.text = pokemon.types[0].type?.name
                hp.text = pokemon.stats[0].baseStat.toString()
                attack.text = pokemon.stats[1].baseStat.toString()
                defense.text = pokemon.stats[2].baseStat.toString()
                specialAttack.text = pokemon.stats[3].baseStat.toString()
                specialDefense.text = pokemon.stats[4].baseStat.toString()
                speed.text = args.pokemon.stats[5].baseStat.toString()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}