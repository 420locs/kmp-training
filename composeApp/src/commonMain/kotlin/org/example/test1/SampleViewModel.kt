package org.example.test1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.aakira.napier.Napier
import kotlinx.coroutines.launch
import org.example.test1.data.network.KtorClient
import org.example.test1.data.network.SamplePlaceholderApi
import org.example.test1.data.network.SamplePlaceholderRepository
import org.example.test1.data.network.SampleTodo


class SampleViewModel : ViewModel() {
    private val repository = SamplePlaceholderRepository()
    var todo by mutableStateOf<List<SampleTodo>?>(null)
        private set
init {
    test()
}
    fun test() {
        Napier.e("Nguuuuuuuuuuu")
        viewModelScope.launch {
            todo = repository.getTodo()
        }
    }
}