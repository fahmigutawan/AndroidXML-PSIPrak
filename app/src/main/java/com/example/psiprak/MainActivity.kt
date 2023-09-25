package com.example.psiprak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psiprak.bab3.Bab3Activity
import com.example.psiprak.bab3_fragment.Bab3FragmentActivity
import com.example.psiprak.bab3_layout.Bab3LayoutInputActivity
import com.example.psiprak.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, Bab3FragmentActivity::class.java);
        startActivity(intent)
    }
}