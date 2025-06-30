package com.example.listadecompras.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemsDao {
    @Insert
    suspend fun insert(item: ItemEntity): Long

    @Delete
    suspend fun delete(item: ItemEntity): Int

    @Query("SELECT * FROM items")
    suspend fun getAll(): List<ItemEntity>

    @Query("SELECT * FROM items WHERE name LIKE '%' || :query || '%'")
    suspend fun searchByName(query: String): List<ItemEntity>

}