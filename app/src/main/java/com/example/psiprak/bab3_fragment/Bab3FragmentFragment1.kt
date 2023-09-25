package com.example.psiprak.bab3_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.psiprak.R
import com.example.psiprak.databinding.Bab3FragmentFragment1Binding

class Bab3FragmentFragment1:Fragment() {
    lateinit var binding : Bab3FragmentFragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Bab3FragmentFragment1Binding.inflate(inflater)

        binding.bab3FragmentPilihgambarBtn.setOnClickListener {

        }

        binding.bab3FragmentKefragmentduaBtn.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.bab3_fragment_mainlayout, Bab3FragmentFragment2())
                addToBackStack("")
            }
        }

        return binding.root
    }
}