package com.example.psiprak.bab3_layout

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.psiprak.databinding.Bab3LayoutInputActivityBinding
import kotlin.system.exitProcess


class Bab3LayoutInputActivity : AppCompatActivity() {
    lateinit var binding: Bab3LayoutInputActivityBinding
    var imgUri = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Bab3LayoutInputActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profilePictureLauncher =
            registerForActivityResult(ActivityResultContracts.GetContent()) {
                it?.let {uriNotNull ->
                    binding.bab3LayoutInputImgIv.setImageURI(uriNotNull)
                    imgUri = uriNotNull.toString()
                }
            }

        binding.bab3LayoutInputPickimgBtn.setOnClickListener {
            profilePictureLauncher.launch("image/*")
        }

        binding.bab3LayoutInputSubmitBtn.setOnClickListener {
            val intent = Intent(this, Bab3LayoutOutputActivity::class.java)
            intent.putExtra("name", binding.bab3LayoutInputNamaEt.text.toString())
            intent.putExtra("ttl", binding.bab3LayoutInputTtlEt.text.toString())
            intent.putExtra("tinggi", binding.bab3LayoutInputTinggiEt.text.toString())
            intent.putExtra("imgUri", imgUri)
            startActivity(intent)
        }

        binding.bab3LayoutInputHapusBtn.setOnClickListener {
            binding.bab3LayoutInputNamaEt.setText("")
            binding.bab3LayoutInputTtlEt.setText("")
            binding.bab3LayoutInputTinggiEt.setText("")
            binding.bab3LayoutInputTinggiSeekbar.setProgress(0)
        }

        binding.bab3LayoutInputTinggiSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.bab3LayoutInputTinggiEt.setText((p1 + 120).toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
}