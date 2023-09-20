package com.example.psiprak.bab3_layout

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.psiprak.databinding.Bab3LayoutOutputActivityBinding

class Bab3LayoutOutputActivity:AppCompatActivity() {
    lateinit var binding:Bab3LayoutOutputActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Bab3LayoutOutputActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bab3LayoutOutputProfileIv.setImageURI(Uri.parse(intent.getStringExtra("imgUri")))
        binding.bab3LayoutOutputNamaTv.text = intent.getStringExtra("name")
        binding.bab3LayoutOutputTinggiTv.text = intent.getStringExtra("tinggi")
        binding.bab3LayoutOutputTtlTv.text = intent.getStringExtra("ttl")
    }
}