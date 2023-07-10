package com.example.efikeyscompose.presentation.modal

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.efikeyscompose.data.dto.Vehicle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ModalViewModel @Inject constructor(

) : ViewModel() {

   private val _vehicleStateFlow = MutableStateFlow(Vehicle.SAMPLE)
   val vehicleStateFlow = _vehicleStateFlow.asStateFlow()


   //TEMPORARY
    fun getVehicleById(id: String) {
        _vehicleStateFlow.value = Vehicle.SAMPLES.find { vehicle ->
            vehicle.id == id
        }!!
    }
}