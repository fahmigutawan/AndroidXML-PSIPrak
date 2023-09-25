package com.example.psiprak.bab3_fragment

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.psiprak.R
import com.example.psiprak.databinding.Bab3FragmentActivityBinding

class Bab3FragmentActivity:AppCompatActivity() {
    lateinit var binding:Bab3FragmentActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Bab3FragmentActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add(R.id.bab3_fragment_mainlayout, Bab3FragmentFragment1())
        }
    }
}