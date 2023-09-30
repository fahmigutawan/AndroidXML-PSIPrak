package com.example.psiprak.bab3_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
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

        val profilePictureLauncher =
            registerForActivityResult(ActivityResultContracts.GetContent()) {
                it?.let {uriNotNull ->
                    binding.bab3FragmentIv.setImageURI(uriNotNull)
                }
            }

        binding.bab3FragmentPilihgambarBtn.setOnClickListener {
            profilePictureLauncher.launch("image/*")
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