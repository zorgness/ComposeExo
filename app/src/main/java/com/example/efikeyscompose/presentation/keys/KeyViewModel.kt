package com.example.efikeyscompose.presentation.keys

import androidx.lifecycle.ViewModel
import com.example.efikeyscompose.data.dto.Vehicle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class KeyViewModel @Inject constructor(

) : ViewModel() {

    private val _searchStateFlow = MutableStateFlow("")
    val searchStateFlow = _searchStateFlow.asStateFlow()

    private val _vehicleListStateFlow = MutableStateFlow<List<Vehicle>>(emptyList())
    val vehicleListStateFlow = _vehicleListStateFlow.asStateFlow()

    private var tmpList = listOf<Vehicle>()

    init {
        tmpList = Vehicle.SAMPLES
        _vehicleListStateFlow.value = tmpList.toList()
    }

    fun updateSearchStr(searchStr: String) {
        _searchStateFlow.value = searchStr
        filterList()
    }

    private fun filterList() {
       _vehicleListStateFlow.value = tmpList.filter {vehicle ->
            vehicle.type.contains(searchStateFlow.value, true) ||
                    vehicle.licensePlate.contains(searchStateFlow.value, true)
       }.toList()
    }

}