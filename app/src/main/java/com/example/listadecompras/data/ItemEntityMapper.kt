package com.example.listadecompras.data

import com.example.listadecompras.model.ItemModel

fun ItemEntity.toModel(onRemove: (ItemModel) -> Unit): ItemModel {
    return ItemModel(
        id = this.id,
        name = this.name,
        itemNumber = this.itemNumber,
        quantity = this.quantity,
        price = this.price,
        description = this.description,
        onRemove = onRemove
    )
}