package com.example.listadecompras

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemAdapter()

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
            val item = ItemModel(
                name= editTextName.text.toString(),
                itemNumber = editTextItemNumber.text.toString().toIntOrNull() ?: 0,
                quantity = editTextQuantity.text.toString().toIntOrNull() ?: 0,
                price = editTextPrice.text.toString().toDoubleOrNull() ?: 0.0,
                description = editTextDescription.text.toString()
            )
            itemsAdapter.addItem(item)
            editTextName.text.clear()
            editTextItemNumber.text.clear()
            editTextQuantity.text.clear()
            editTextPrice.text.clear()
            editTextDescription.text.clear()
        }
    }
}