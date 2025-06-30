package com.example.listadecompras.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadecompras.data.ItemEntity
import com.example.listadecompras.data.ItemsDatabase
import com.example.listadecompras.data.toModel
import com.example.listadecompras.model.ItemModel
import com.example.listadecompras.model.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(
    private val database: ItemsDatabase ): ViewModel() {
    val itemsLiveData = MutableLiveData<List<ItemModel>>()

    fun addItem(name: String, itemNumber: Int, quantity: Int, price: Double, description: String) { viewModelScope.launch(Dispatchers.IO) {
        val entity = ItemEntity(
            id = 0,
            name = name,
            itemNumber = itemNumber,
            quantity = quantity,
            price = price,
            description = description
        )
        database.itemsDao().insert(entity)
        fetchAll()
    }   }
    fun removeItem(item: ItemModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val entity = item.toEntity()
            database.itemsDao().delete(entity)
            fetchAll()
        } }
    private suspend fun fetchAll() {
        val result = database.itemsDao().getAll().map {
            it.toModel(onRemove = ::removeItem)
        }
        itemsLiveData.postValue(result)
    }
    init {
        viewModelScope.launch(Dispatchers.IO) {
            fetchAll()
        } }

}