package com.example.diagnal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.diagnal.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchBt.setOnClickListener {
            binding.titleLayout.visibility = View.GONE
            binding.searchLayout.visibility = View.VISIBLE

        }

        binding.backBt.setOnClickListener {
            // @TODO
        }

        binding.searchCloseBt.setOnClickListener {
            binding.titleLayout.visibility = View.VISIBLE
            binding.searchLayout.visibility = View.GONE
        }

    }

}