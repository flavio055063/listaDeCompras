package com.example.listadecompras.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecompras.R
import com.example.listadecompras.model.ItemModel

class ItemAdapter(
    private val onDeleteClick: (ItemModel) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var items = listOf<ItemModel>()

    fun updateItems(newItems: List<ItemModel>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view, onDeleteClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }


    class ItemViewHolder(
        itemView: View,
        private val onDeleteClick: (ItemModel) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        val textViewNumeroItem = itemView.findViewById<TextView>(R.id.textViewNumeroItem)
        val textViewName = itemView.findViewById<TextView>(R.id.textViewNomeItem)
        val textViewQuantidade = itemView.findViewById<TextView>(R.id.textViewQuantidade)
        val textViewPreco = itemView.findViewById<TextView>(R.id.textViewPreco)
        val textViewDescricao = itemView.findViewById<TextView>(R.id.textViewDescricao)
        val buttonDelete = itemView.findViewById<ImageButton>(R.id.buttonRemoverItem)

        fun bind(item: ItemModel) {
            textViewNumeroItem.text = "item nº ${item.itemNumber}"
            textViewName.text = item.name
            textViewQuantidade.text = "qtd: ${item.quantity}"
            textViewPreco.text = "R$ ${String.format("%.2f", item.price)}"
            textViewDescricao.text = item.description

            buttonDelete.setOnClickListener {
                onDeleteClick(item)
            }
        }
    }
}
