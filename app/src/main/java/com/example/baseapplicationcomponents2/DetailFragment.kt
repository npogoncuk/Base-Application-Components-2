package com.example.baseapplicationcomponents2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.baseapplicationcomponents2.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(args) {
            binding?.name?.text = name
            binding?.number?.text = number
            binding?.organization?.text = organization
            binding?.email?.text = email
        }
        binding?.number?.setOnClickListener() {
            Toast.makeText(requireContext(), binding?.number?.text, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}