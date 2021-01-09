package br.ufc.kotlincomponentesbasicos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class RecyclerAdapter(private val itens: ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false) as TextView

        return MyViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return  itens.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {
        holder.textView.text = itens[position]
    }

}