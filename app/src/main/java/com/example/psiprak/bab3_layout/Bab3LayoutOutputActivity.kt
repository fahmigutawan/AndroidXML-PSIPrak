package com.example.psiprak.bab3_layout

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
    }
}