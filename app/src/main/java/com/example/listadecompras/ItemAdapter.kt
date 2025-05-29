package com.example.listadecompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter : RecyclerView.Adapter <ItemAdapter.ItemViewHolder> () {

    private  val items = mutableListOf<ItemModel>()

    fun addItem(newItem: ItemModel){
        items.add(newItem)
        items.sortBy { it.name }
        notifyDataSetChanged()
    }

    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    //botão para remover o item da lista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.findViewById<ImageButton>(R.id.buttonRemoverItem).setOnClickListener {
            removeItem(item)
        }
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewNumeroItem = itemView.findViewById<TextView>(R.id.textViewNumeroItem)
        val textViewName = itemView.findViewById<TextView>(R.id.textViewNomeItem)
        val textViewQuantidade = itemView.findViewById<TextView>(R.id.textViewQuantidade)
        val textViewPreco = itemView.findViewById<TextView>(R.id.textViewPreco)
        val textViewDescricao = itemView.findViewById<TextView>(R.id.textViewDescricao)
        val buttonDelete = itemView.findViewById<ImageButton>(R.id.buttonRemoverItem)
        fun bind(item: ItemModel){
            textViewNumeroItem.text = "item nº ${item.itemNumber.toString()}"
            textViewName.text=item.name
            textViewQuantidade.text = "qtd: " + item.quantity.toString()
            textViewPreco.text = "R$ ${String.format("%.2f", item.price)}"
            textViewDescricao.text = item.description
        }
    }


}