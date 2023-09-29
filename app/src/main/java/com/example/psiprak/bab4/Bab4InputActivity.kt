package com.example.psiprak.bab4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.psiprak.databinding.Bab4InputActivityBinding

class Bab4InputActivity : AppCompatActivity() {
    lateinit var binding: Bab4InputActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Bab4InputActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding
            .bab4InputHitungBtn
            .setOnClickListener {
                val intent = Intent(
                    this,
                    Bab4OutputActivity::class.java
                )

                intent.putExtra(
                    "luas",
                    (binding
                        .bab4InputEt
                        .text
                        .toString()
                        .toDoubleOrNull()
                        ?: .0)
                        .volume()
                )

                startActivity(intent)
            }
    }

    fun Double.volume(): Double {
        return (this * this * this)
    }
}