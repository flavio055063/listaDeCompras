package com.example.listadecompras.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.content.Intent
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

        // Total dos valores
        val textViewTotal = findViewById<TextView>(R.id.textViewTotal)

        // Lista de itens
        viewModel.itemsLiveData.observe(this) {
                items ->itemsAdapter.updateItems(items)
                val total = items.sumOf { it.price * it.quantity } //soma o total dos itens
                textViewTotal.text = "Total: R$ %.2f".format(total)
        }

        // Botão de adicionar
        findViewById<View>(R.id.fabAdicionar).setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startActivity(intent)
        }

        // Botão de pesquisa (abre tela em branco por enquanto)
        findViewById<View>(R.id.fabPesquisar).setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }

    // Isso serve para atualizar os itens visto que
    // utilizei activity e não fragment
    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }
}