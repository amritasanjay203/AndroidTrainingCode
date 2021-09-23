package com.example.androidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var mButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mButton = findViewById(R.id.button)
        // Step 1 -> User has to click the button
        // Step 2 -> After Step 1 (user clicks), show the toast

        // OnClickListener is a callback
        mButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "button was clicked", Toast.LENGTH_SHORT).show()
        })
    }
}