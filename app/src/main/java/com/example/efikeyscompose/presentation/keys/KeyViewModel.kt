package com.example.efikeyscompose.presentation.keys

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class KeyViewModel @Inject constructor(

) : ViewModel() {

    private val _searchStateFlow = MutableStateFlow("")
    val searchStateFlow = _searchStateFlow.asStateFlow()


    fun updateSearchStr(searchStr: String) {
        _searchStateFlow.value = searchStr
    }

}