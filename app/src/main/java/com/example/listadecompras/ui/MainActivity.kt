package com.example.listadecompras.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecompras.viewmodel.ItemsViewModel
import com.example.listadecompras.R
import com.example.listadecompras.viewmodel.ItemsViewModelFactory

class MainActivity : AppCompatActivity() {
    val viewModel: ItemsViewModel by viewModels {
        ItemsViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemAdapter { item ->
            viewModel.removeItem(item) // ViewModel que chama Repository -> DAO
        }
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editTextName = findViewById<EditText>(R.id.editTextNome)
        val editTextItemNumber = findViewById<EditText>(R.id.editTextNumeroItem)
        val editTextQuantity = findViewById<EditText>(R.id.editTextQuantidade)
        val editTextPrice = findViewById<EditText>(R.id.editTextPreco)
        val editTextDescription = findViewById<EditText>(R.id.editTextDescricao)

        button.setOnClickListener{
            if(editTextName.text.isEmpty()) {
                editTextName.error = "Preencha o nome do item"
                return@setOnClickListener
            }
            if(editTextItemNumber.text.isEmpty()) {
                editTextItemNumber.error = "Preencha o número do item"
                return@setOnClickListener
            }
            if(editTextQuantity.text.isEmpty()) {
                editTextQuantity.error = "Preencha a quantidade"
                return@setOnClickListener
            }
            if(editTextPrice.text.isEmpty()) {
                editTextPrice.error = "Preencha o preço"
                return@setOnClickListener
            }

            viewModel.addItem(editTextName.text.toString(),
                editTextItemNumber.text.toString().toInt(),
                editTextQuantity.text.toString().toInt(),
                editTextPrice.text.toString().toDouble(),
                editTextDescription.text.toString())

            editTextName.text.clear()
            editTextItemNumber.text.clear()
            editTextQuantity.text.clear()
            editTextPrice.text.clear()
            editTextDescription.text.clear()
        }
        viewModel.itemsLiveData.observe(this) {
                items ->itemsAdapter.updateItems(items)
        }
    }
}