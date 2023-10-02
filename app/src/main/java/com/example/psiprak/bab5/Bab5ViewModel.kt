package com.example.psiprak.bab5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Exception

class Bab5ViewModel : ViewModel() {
    private val _datas = MutableLiveData<ArrayList<Bab5KendaraanModel>>()
    val datas: LiveData<ArrayList<Bab5KendaraanModel>> = _datas

    val pickedData = MutableLiveData<Bab5KendaraanModel?>()

    init {
        _datas.postValue(ArrayList())
        pickedData.postValue(null)
    }

    fun addDataParkir(
        onItemExisted:() -> Unit,
        pelatNomer: String,
        warnaKendaraan: String
    ) {
        _datas.value?.filter {
            it.pelat_nomor.replace(" ", "").lowercase().trim() == pelatNomer.replace(" ", "")
                .lowercase().trim()
        }?.let {
            if(it.isNotEmpty()){
                onItemExisted()
                return
            }
        }
        _datas.postValue(
            _datas.value.apply {
                this?.add(
                    Bab5KendaraanModel(
                        pelatNomer.uppercase().trim(),
                        warnaKendaraan
                    )
                )
            }
        )
    }

    fun editDataParkir(pelatNomer: String, warnaKendaraan: String) {
        try {
            _datas.postValue(
                _datas.value.apply {
                    val index = this?.indexOf(this.findLast {
                        it.pelat_nomor.replace(" ", "").lowercase().trim() == pelatNomer.replace(" ", "")
                            .lowercase().trim()
                    })
                    this?.set(
                        index ?: -1,
                        Bab5KendaraanModel(
                            pelatNomer.uppercase().trim(),
                            warnaKendaraan
                        )
                    )
                }
            )
        } catch (e: Exception) {
            //HANDLE LATER
        }
    }

    fun removeDataParkir(index: Int) {
        _datas.postValue(
            _datas.value.apply {
                this?.removeAt(index)
            }
        )
    }
}