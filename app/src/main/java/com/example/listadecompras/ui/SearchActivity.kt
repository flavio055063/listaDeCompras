package com.example.listadecompras.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecompras.R
import com.example.listadecompras.viewmodel.ItemsViewModel
import com.example.listadecompras.viewmodel.ItemsViewModelFactory

class SearchActivity : AppCompatActivity() {
    private val viewModel: ItemsViewModel by viewModels { ItemsViewModelFactory(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val editText = findViewById<EditText>(R.id.editTextSearch)
        val button = findViewById<Button>(R.id.buttonSearch)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewSearch)

        val adapter = ItemAdapter { item ->
            viewModel.removeItem(item) // ViewModel que chama Repository -> DAO
        }

        recyclerView.adapter = adapter

        viewModel.searchResults.observe(this) { items ->
            adapter.updateItems(items)
        }

        button.setOnClickListener {
            val query = editText.text.toString().trim()
            if (query.isNotEmpty()) {
                viewModel.searchByName(query)
            } else {
                Toast.makeText(this, "Digite um nome para buscar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

