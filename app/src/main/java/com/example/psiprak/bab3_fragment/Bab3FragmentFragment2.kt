package com.example.psiprak.bab3_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.psiprak.R
import com.example.psiprak.databinding.Bab3FragmentFragment2Binding

class Bab3FragmentFragment2:Fragment() {
    lateinit var binding:Bab3FragmentFragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Bab3FragmentFragment2Binding.inflate(inflater)

        binding.bab3FragmentKefragmentsatuBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }
}