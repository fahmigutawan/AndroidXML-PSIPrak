package com.example.psiprak.bab3_fragment

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.psiprak.databinding.Bab3FragmentActivityBinding

class Bab3FragmentActivity:AppCompatActivity() {
    lateinit var binding:Bab3FragmentActivityBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = Bab3FragmentActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}