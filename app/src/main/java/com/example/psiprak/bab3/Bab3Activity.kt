package com.example.psiprak.bab3

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.StackView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.psiprak.R
import com.example.psiprak.databinding.Bab3ActivityBinding

class Bab3Activity : AppCompatActivity() {
    lateinit var binding:Bab3ActivityBinding
    lateinit var bab3Layout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Bab3ActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bab3Layout = binding.bab3Layout

        bab3Layout.addView(
            TextView(this).apply {
                text = "Melewati ON CREATE"
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        )
    }

    override fun onStart() {
        super.onStart()

        bab3Layout.addView(
            TextView(this).apply {
                text = "Melewati ON START"
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        )
    }

    override fun onRestart() {
        super.onRestart()

        bab3Layout.addView(
            TextView(this).apply {
                text = "Melewati ON RESTART"
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        )
    }

    override fun onResume() {
        super.onResume()

        bab3Layout.addView(
            TextView(this).apply {
                text = "Melewati ON RESUME"
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        )
    }

    override fun onPause() {
        super.onPause()
        bab3Layout.addView(
            LayoutInflater
                .from(this)
                .inflate(
                    R.layout.bab3_onpause,
                    null
                )
        )
    }

    override fun onStop() {
        super.onStop()

        bab3Layout.addView(
            TextView(this).apply {
                text = "Melewati ON STOP"
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        )
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("BAB 3", "MELEWATI ON DESTROY")
    }
}