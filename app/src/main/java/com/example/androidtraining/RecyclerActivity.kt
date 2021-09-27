package com.example.androidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var coutries = arrayListOf<String>("india","usa","uk","australia")//plug

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        var recyclerView: RecyclerView = findViewById(R.id.countriesRV)  //taking the handle of recyclerview

        var adapter = WordsAdapter(coutries)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}