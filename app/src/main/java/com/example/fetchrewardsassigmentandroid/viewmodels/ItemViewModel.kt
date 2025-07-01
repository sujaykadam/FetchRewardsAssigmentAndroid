package com.example.fetchrewardsassigmentandroid.viewmodels

import androidx.lifecycle.*
import com.example.fetchrewardsassigmentandroid.data.model.Item
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {
    private val _items = MutableLiveData<Map<Int, List<Item>>>()
    val items: LiveData<Map<Int, List<Item>>> = _items

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun fetchItems() {
        viewModelScope.launch {
            try {
                val allItems = RetrofitInstance.api.getItems()
                val filtered = allItems.filter { it.name.isNotBlank() }
                    .sortedWith(compareBy<Item> { it.listId }.thenBy {
                        Regex("""\d+""").find(it.name)?.value?.toIntOrNull() ?: Int.MAX_VALUE
                    })
                    .groupBy { it.listId }

                _items.value = filtered
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Failed to load items. Please check your connection."
                // Set default blank data object
                val blankItem = Item(id = 0, listId = 0, name = "")
                _items.value = mapOf(0 to listOf(blankItem))
            }
        }
    }
}
