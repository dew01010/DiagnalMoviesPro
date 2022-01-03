package com.example.diagnal.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.diagnal.MainApp.Companion.getAppComponent
import com.example.diagnal.databinding.FragmentHomeBinding
import com.example.diagnal.util.PagingLoadStateAdapter
import com.example.diagnal.util.Resource
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MovieAdapter

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

        setUpAdapter()

        lifecycleScope.launchWhenStarted {
            viewModel.moviesFlow.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun setUpAdapter() {
        adapter = MovieAdapter()
        binding.rvMovie.adapter = adapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // inject app component
        getAppComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }
}