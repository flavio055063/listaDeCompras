package com.example.listadecompras.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.listadecompras.data.ItemsDatabase

class ItemsViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val db = Room.databaseBuilder(
            context.applicationContext,
            ItemsDatabase::class.java,
            "items.db"
        ).build()

        return ItemsViewModel(db) as T
    }
}