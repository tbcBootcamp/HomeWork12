package com.example.homework12

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.homework12.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            args.productInfo.apply {
                ivPhoto.setImageResource(image)
                tvName.text = name
                tvTextDescription.text = description
                tvRate.text = rate.toString()
                tvPrice.text = price
            }
        }
        var count = 1
        with(binding) {
            btnPlus.setOnClickListener {
                count++
                binding.tvCount.text = "$count"
            }
            btnMinus.setOnClickListener {
                if (count > 1) {
                    count--
                    binding.tvCount.text = "$count"
                }
            }
        }


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}