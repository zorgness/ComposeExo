package com.example.efikeyscompose.shared_viewmodel

import androidx.lifecycle.ViewModel
import com.example.efikeyscompose.data.dto.Garage
import com.example.efikeyscompose.data.dto.Vehicle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeAndSiteViewModel @Inject constructor(

) : ViewModel() {

    private val _selectedGarageStateFlow = MutableStateFlow(Garage.SAMPLE)
    val selectedGarageStateFlow = _selectedGarageStateFlow.asStateFlow()

    private val _vehicleListStateFlow = MutableStateFlow<List<Vehicle>>(emptyList())
    val vehicleListStateFlow = _vehicleListStateFlow.asStateFlow()

    init {
        _vehicleListStateFlow.value = listOf(
            Vehicle.SAMPLE,
            Vehicle.SAMPLE,
            Vehicle.SAMPLE,
            Vehicle.SAMPLE,
            Vehicle.SAMPLE,
        )
    }

    fun updateSelectedGarage(garage: Garage) {
        _selectedGarageStateFlow.value = garage
    }
}