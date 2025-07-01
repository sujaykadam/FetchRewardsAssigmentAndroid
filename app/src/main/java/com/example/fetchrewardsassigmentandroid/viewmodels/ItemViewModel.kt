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
                .sortedWith(compareBy({ it.listId }, { it.name }))
                .groupBy { it.listId }

            _items.value = filtered
        }
    }
}
