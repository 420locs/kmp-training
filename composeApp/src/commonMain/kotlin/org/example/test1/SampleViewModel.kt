package org.example.test1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.test1.data.network.SamplePlaceholderRepository
import org.example.test1.data.network.SampleTodo


class SampleViewModel : ViewModel() {
    private val repository = SamplePlaceholderRepository()
    var todo by mutableStateOf<Result<List<SampleTodo>>?>(null)
        private set

    fun test() {
        viewModelScope.launch {
            todo = Result.success(repository.getTodo())
        }
    }
}