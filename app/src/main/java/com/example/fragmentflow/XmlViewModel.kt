package com.example.fragmentflow

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class XmlViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    companion object {
        const val KEY = "KEY_XML_VIEW_MODEL_COUNTER"
    }

    val savedStateFlowWithLifecycle = savedStateHandle
        .getStateFlow(KEY, 0)
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(0),
            0
        )

    init {
        Log.d("Track", "XmlViewModel Init")
        viewModelScope.launch {
            while (true) {
                delay(1000)
                savedStateHandle[KEY] =
                    savedStateFlowWithLifecycle.value + 1
            }
        }
    }
}
