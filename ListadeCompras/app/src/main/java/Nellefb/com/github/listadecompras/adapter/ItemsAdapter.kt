package Nellefb.com.github.listadecompras.adapter

import Nellefb.com.github.listadecompras.R
import Nellefb.com.github.listadecompras.model.ItemModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//herda de recycle, adapter faz a ponte entre dados e layout em um reclycleview
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

//    item c varios itens, lista mutavel,
    private val items = mutableListOf<ItemModel>()

//    adc item recebido do item model, notify eh um refresh, muda os estados
    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }
// para remover item
    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

//    faz visualização, viewgroup responsável por mostrar, layout ifla -> insere dados no layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }


    override fun getItemCount(): Int = items.size

//    bind junta valor c objeto
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

//    r é resources
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        fun bind(item: ItemModel) {
            textView.text = item.name
        }
    }
}