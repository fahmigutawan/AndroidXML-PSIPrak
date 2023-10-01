package com.example.psiprak.bab5

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.psiprak.databinding.Bab5ActivityBinding


class Bab5Activity : AppCompatActivity() {
    lateinit var binding: Bab5ActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<Bab5ViewModel>()
        binding = Bab5ActivityBinding.inflate(layoutInflater)
        binding.bab5ListRv.adapter = Bab5RvAdapter(ArrayList())
        setContentView(binding.root)

        binding.bab5AddEditBtn.setOnClickListener {
            if (
                binding.bab5PelatEt.text.toString().isEmpty() ||
                binding.bab5WarnaEt.text.toString().isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Pastikan tidak ada data kosong",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                if (viewModel.pickedData.value == null) {
                    viewModel.addDataParkir(
                        binding.bab5PelatEt.text.toString(),
                        binding.bab5WarnaEt.text.toString()
                    )
                } else {
                    viewModel.editDataParkir(
                        binding.bab5PelatEt.text.toString(),
                        binding.bab5WarnaEt.text.toString()
                    )
                }
            }
        }
        viewModel.pickedData.observe(this) {
            if (it == null) {
                binding.bab5AddEditBtn.text = "BUAT"
            } else {
                binding.bab5AddEditBtn.text = "EDIT"
            }
        }
        viewModel.datas.observe(this){
            binding.bab5ListRv.adapter = Bab5RvAdapter(it)
        }
    }
}