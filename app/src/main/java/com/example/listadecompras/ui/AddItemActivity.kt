package com.example.listadecompras.ui

import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.listadecompras.R
import com.example.listadecompras.viewmodel.ItemsViewModel
import com.example.listadecompras.viewmodel.ItemsViewModelFactory

class AddItemActivity : AppCompatActivity() {

    val viewModel: ItemsViewModel by viewModels {
        ItemsViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        val editTextName = findViewById<EditText>(R.id.editTextNome)
        val editTextItemNumber = findViewById<EditText>(R.id.editTextNumeroItem)
        val editTextQuantity = findViewById<EditText>(R.id.editTextQuantidade)
        val editTextPrice = findViewById<EditText>(R.id.editTextPreco)
        val editTextDescription = findViewById<EditText>(R.id.editTextDescricao)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            // mesma validação anterior
            if (editTextName.text.isEmpty() || editTextItemNumber.text.isEmpty() || editTextQuantity.text.isEmpty() || editTextPrice.text.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.addItem(
                editTextName.text.toString(),
                editTextItemNumber.text.toString().toInt(),
                editTextQuantity.text.toString().toInt(),
                editTextPrice.text.toString().toDouble(),
                editTextDescription.text.toString()
            )
            finish() // volta pra MainActivity
        }
    }
}
