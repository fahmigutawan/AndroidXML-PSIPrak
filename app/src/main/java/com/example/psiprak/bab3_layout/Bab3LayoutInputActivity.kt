package com.example.psiprak.bab3_layout

import android.content.Intent
import android.os.Bundle
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
            intent.putExtra("name", binding.bab3LayoutInputNamaEt.text)
            intent.putExtra("ttl", binding.bab3LayoutInputTtlEt.text)
            intent.putExtra("tinggi", binding.bab3LayoutInputTinggiEt.text)
            intent.putExtra("imgUri", imgUri)
        }

        binding.bab3LayoutInputKeluarBtn.setOnClickListener {
            exitProcess(0)
        }
    }
}