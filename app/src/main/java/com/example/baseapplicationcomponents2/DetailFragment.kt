package com.example.baseapplicationcomponents2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        binding?.number?.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${binding?.number?.text.toString()}"))
            if (intent.resolveActivity(requireActivity().packageManager) != null) startActivity(intent)
        }

        binding?.email?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)

            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, binding?.email?.text.toString())

            if (intent.resolveActivity(activity!!.packageManager) != null) {
                startActivity(intent)
            } else Log.d("emailIntent", "null")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}