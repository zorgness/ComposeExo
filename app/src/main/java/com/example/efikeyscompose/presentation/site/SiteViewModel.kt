package com.example.efikeyscompose.presentation.site

import androidx.lifecycle.ViewModel
import com.example.efikeyscompose.data.dto.Garage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SiteViewModel @Inject constructor(

) : ViewModel() {


   private val _selectedStateFlow = MutableStateFlow(Garage.SAMPLE.id)
   val selectedStateFlow = _selectedStateFlow.asStateFlow()

    fun updateSelected(id: Long) {
        _selectedStateFlow.value = id
    }

}