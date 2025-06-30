package com.example.listadecompras.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val itemNumber: Int,
    val quantity: Int,
    val price: Double,
    val description: String
)