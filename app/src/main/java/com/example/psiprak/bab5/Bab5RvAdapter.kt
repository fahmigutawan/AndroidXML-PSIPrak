package com.example.psiprak.bab5

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.psiprak.R
import com.example.psiprak.databinding.Bab5KendaraanItemBinding

class Bab5RvAdapter(
    private val items:List<Bab5KendaraanModel>,
    private val onEditClicked:(item:Bab5KendaraanModel) -> Unit,
    private val onHapusClicked:(index:Int) -> Unit
) : RecyclerView.Adapter<Bab5RvViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Bab5RvViewHolder {
        val binding = Bab5KendaraanItemBinding.inflate(LayoutInflater.from(parent.context))

        return Bab5RvViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Bab5RvViewHolder, position: Int) {
        holder.binding.apply {
            bab5KendaraanitemPelatTv.text = items[position].pelat_nomor
            bab5KendaraanitemWarnaTv.text = items[position].warna_kendaraan
            bab5KendaraanitemEditBtn.setOnClickListener {
                onEditClicked(items[position])
            }
            bab5KendaraanitemHapusBtn.setOnClickListener {
                onHapusClicked(position)
            }
        }
    }
}

class Bab5RvViewHolder(val binding: Bab5KendaraanItemBinding) : RecyclerView.ViewHolder(binding.root)