package com.example.efikeyscompose.presentation.vehicle_new

import androidx.lifecycle.ViewModel
import com.example.efikeyscompose.data.dto.AddVehicleItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class VehicleNewViewModel @Inject constructor(

) : ViewModel() {

    private val _licenceStateFlow = MutableStateFlow("")
    val licenceStateFlow = _licenceStateFlow.asStateFlow()

    private val _kilometersStateFlow = MutableStateFlow(0L)
    val kilometersStateFlow = _kilometersStateFlow.asStateFlow()

    private var _itemListStateFlow = MutableStateFlow<List<AddVehicleItem>>(emptyList())

    val itemListStateFlow = _itemListStateFlow.asStateFlow()

    private var tmpList = mutableListOf<AddVehicleItem>()

    init {
        addToList(AddVehicleItem.CameraCard)
    }

    fun addToList(carItem: AddVehicleItem) {
        tmpList.add(carItem)
        _itemListStateFlow.value = tmpList.toList()
    }

    fun removeItem(carItem: AddVehicleItem) {
        tmpList.remove(carItem)
        _itemListStateFlow.value = tmpList.toList()
    }

    fun updateLicense(licence: String) {
        _licenceStateFlow.value = licence
    }

    fun updateKilometers(kilometers: Long) {
        _kilometersStateFlow.value = kilometers
    }

}