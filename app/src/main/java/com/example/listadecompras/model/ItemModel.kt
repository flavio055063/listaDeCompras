package com.example.listadecompras.model
import com.example.listadecompras.data.ItemEntity
import kotlin.Int

class ItemModel (
    val id: Long,
    val name : String,
    val itemNumber: Int,
    val quantity: Int,
    val price: Double,
    val description: String,
    val onRemove: (com.example.listadecompras.model.ItemModel) -> Unit) {
}

fun com.example.listadecompras.model.ItemModel.toEntity(): ItemEntity {
    return ItemEntity(
        id = this.id,
        name = this.name,
        itemNumber = this.itemNumber,
        quantity = this.quantity,
        price = this.price,
        description = this.description
    ) }