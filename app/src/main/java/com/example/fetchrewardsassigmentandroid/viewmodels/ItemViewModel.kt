package com.example.fetchrewardsassigmentandroid.viewmodels

import androidx.lifecycle.*
import com.example.fetchrewardsassigmentandroid.data.model.Item
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {
    private val _items = MutableLiveData<Map<Int, List<Item>>>()
    val items: LiveData<Map<Int, List<Item>>> = _items

    fun fetchItems() {
        viewModelScope.launch {
            val allItems = RetrofitInstance.api.getItems()
            val filtered = allItems.filter { it.name.isNotBlank() }
                .sortedWith(compareBy<Item> { it.listId }.thenBy {
                    Regex("""\d+""").find(it.name)?.value?.toIntOrNull() ?: Int.MAX_VALUE
                })
                .groupBy { it.listId }

            _items.value = filtered
        }
    }
}
