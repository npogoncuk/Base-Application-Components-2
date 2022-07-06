package com.example.baseapplicationcomponents2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.baseapplicationcomponents2.data.Datasource
import com.example.baseapplicationcomponents2.databinding.FragmentItemListBinding
import com.example.baseapplicationcomponents2.model.Contact


/**
 * A fragment representing a list of Items.
 */
class ContactFragment : Fragment() {

    private var binding: FragmentItemListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentItemListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.list?.adapter = MyContactRecyclerViewAdapter(Datasource.getContacts())

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}