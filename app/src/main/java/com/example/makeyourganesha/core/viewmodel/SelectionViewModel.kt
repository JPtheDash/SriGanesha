package com.example.makeyourganesha.core.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.makeyourganesha.core.data.CreationSelection
import com.example.makeyourganesha.core.data.SelectionStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SelectionViewModel(application: Application) : AndroidViewModel(application) {
    private val store = SelectionStore(application)

    val selection: StateFlow<CreationSelection> = store.flow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = CreationSelection()
    )

    fun updateHead(value: String) = update(CreationSelection(head = value))
    fun updateBody(value: String) = update(CreationSelection(body = value))
    fun updateVahana(value: String) = update(CreationSelection(vahana = value))
    fun updateStage(value: String) = update(CreationSelection(stage = value))
    fun updateBackground(value: String) = update(CreationSelection(background = value))
    fun updateArtifacts(value: String) = update(CreationSelection(artifacts = value))

    private fun update(update: CreationSelection) {
        viewModelScope.launch { store.update(update) }
    }
}

