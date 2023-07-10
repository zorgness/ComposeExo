package com.example.efikeyscompose.presentation.home

import androidx.lifecycle.ViewModel
import com.example.efikeyscompose.data.dto.Vehicle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {
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
}