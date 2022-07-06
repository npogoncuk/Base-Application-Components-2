package com.example.baseapplicationcomponents2

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.baseapplicationcomponents2.databinding.FragmentItemBinding
import com.example.baseapplicationcomponents2.model.Contact
import java.nio.file.Files.size

class MyContactRecyclerViewAdapter(
    private val contacts: List<Contact>
) : RecyclerView.Adapter<MyContactRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.textViewName.text = contact.name
        holder.textViewNumber.text = contact.number
    }

    override fun getItemCount(): Int = contacts.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val textViewName: TextView = binding.itemName
        val textViewNumber: TextView = binding.itemNumber

    }

}