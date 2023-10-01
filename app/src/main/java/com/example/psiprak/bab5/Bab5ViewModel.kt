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

    fun addDataParkir(pelatNomer: String, warnaKendaraan: String) {
        _datas.postValue(
            _datas.value.apply {
                this?.add(
                    Bab5KendaraanModel(
                        pelatNomer.replace(" ", "").lowercase(),
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
                        it.pelat_nomor == pelatNomer.replace(" ", "").lowercase()
                    })
                    this?.set(
                        index ?: -1,
                        Bab5KendaraanModel(
                            pelatNomer.replace(" ", "").lowercase(),
                            warnaKendaraan
                        )
                    )
                }
            )
        } catch (e: Exception) {
            //HANDLE LATER
        }
    }

    fun removeDataParkir(pelatNomer: String) {
        _datas.postValue(
            _datas.value.apply {
                this?.removeIf {
                    it.pelat_nomor == pelatNomer
                }
            }
        )
    }
}