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
        binding.bab5ListRv.adapter = Bab5RvAdapter(ArrayList(),{},{})
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
            } else {
                if (viewModel.pickedData.value == null) {
                    viewModel.addDataParkir(
                        pelatNomer = binding.bab5PelatEt.text.toString(),
                        warnaKendaraan = binding.bab5WarnaEt.text.toString(),
                        onItemExisted = {
                            Toast.makeText(
                                this,
                                "Kendaraan dengan pelat sama sudah ada",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                } else {
                    viewModel.editDataParkir(
                        binding.bab5PelatEt.text.toString(),
                        binding.bab5WarnaEt.text.toString()
                    )
                }

                binding.bab5PelatEt.setText("")
                binding.bab5WarnaEt.setText("")
                viewModel.pickedData.postValue(null)
            }
        }
        viewModel.pickedData.observe(this) {
            if (it == null) {
                binding.apply {
                    bab5AddEditBtn.text = "BUAT"
                }
            } else {
                binding.apply {
                    bab5AddEditBtn.text = "EDIT"
                    bab5PelatEt.setText(it.pelat_nomor)
                    bab5WarnaEt.setText(it.warna_kendaraan)
                }
            }
        }
        viewModel.datas.observe(this) {
            binding.bab5ListRv.adapter =
                Bab5RvAdapter(
                    items = it,
                    onEditClicked = { picked ->
                        viewModel.pickedData.postValue(picked)
                    },
                    onHapusClicked = { index ->
                        viewModel.removeDataParkir(index)
                        if(viewModel.pickedData.value != null){
                            viewModel.pickedData.postValue(null)
                        }
                    }
                )
        }
    }
}