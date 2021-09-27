package com.example.androidtraining

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(val coutries: ArrayList<String>) : RecyclerView.Adapter<WordsAdapter.WordsViewHolder>() {

    //purshottam --- manage the wooden planks bought by suhas
    class WordsViewHolder(woodenPlank: View) : RecyclerView.ViewHolder(woodenPlank) {
        var tvRowPlank: TextView = woodenPlank.findViewById(R.id.tvRowPlank)

    }

    //suhas -- buy new planks if required
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val woodenPlank = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return WordsViewHolder(woodenPlank)
    }

    //shreyas -- handwriting good-- write on planks
    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.tvRowPlank.text = coutries.get(position)

    }

    //richa - keep the count of the data in dataset
    override fun getItemCount(): Int {
        return coutries.size
    }

}
