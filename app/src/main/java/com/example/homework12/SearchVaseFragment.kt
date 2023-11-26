package com.example.homework12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework12.adapters.ProductAdapter
import com.example.homework12.data.VaseList
import com.example.homework12.databinding.FragmentSearchVaseBinding

class SearchVaseFragment : Fragment() {

    private lateinit var adapter: ProductAdapter
    private var _binding: FragmentSearchVaseBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSearchVaseBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ProductAdapter()
        binding.rvImages.layoutManager =
            GridLayoutManager(requireContext(),2)
        binding.rvImages.adapter = adapter
        adapter.submitList(VaseList().getList())


        binding.etSearch.doOnTextChanged { text, start, before, count ->
            text?.let { input ->
                val filtered = VaseList().getList().filter { it.name.contains(input) }
                adapter.submitList(filtered)
            }

        }

        adapter.onItemClick = {
            findNavController().navigate(
                SearchVaseFragmentDirections.actionSearchVaseFragmentToDetailsFragment(
                    it
                )
            )
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}