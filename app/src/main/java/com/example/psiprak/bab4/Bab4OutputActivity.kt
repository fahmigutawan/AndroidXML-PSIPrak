package com.example.psiprak.bab4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.psiprak.databinding.Bab4OutputActivityBinding

class Bab4OutputActivity:AppCompatActivity() {
    lateinit var binding:Bab4OutputActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Bab4OutputActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}