package com.example.psiprak.bab4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.psiprak.databinding.Bab4OutputActivityBinding

class Bab4OutputActivity : AppCompatActivity() {
    lateinit var binding: Bab4OutputActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Bab4OutputActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bab4OutputLuasTv.text = String.format("%.2f", intent.getDoubleExtra("luas", .0))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        getSharedPreferences("pref", MODE_PRIVATE).edit {
            putString("luas", String.format("%.2f", intent.getDoubleExtra("luas", .0)))
            apply()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        getSharedPreferences("pref", MODE_PRIVATE)
            .getString("luas", null)
            ?.let {
                binding.bab4OutputLuasTv.text = it
            }
    }
}