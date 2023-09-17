package com.example.psiprak.bab3

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.psiprak.databinding.Bab3Binding

class Bab3Activity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val binding = Bab3Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}