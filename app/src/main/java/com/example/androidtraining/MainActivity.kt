package com.example.androidtraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var mButton: Button
    lateinit var etName: EditText
    lateinit var tvRes: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // inflating layout

        etName = findViewById(R.id.etName)
        tvRes = findViewById(R.id.textView)
//        mButton = findViewById(R.id.button)
        // Step 1 -> User has to click the button
        // Step 2 -> After Step 1 (user clicks), show the toast

        // OnClickListener is a callback
//        mButton.setOnClickListener(View.OnClickListener {
//            Toast.makeText(this, "button was clicked", Toast.LENGTH_SHORT).show()
//        })
    }

    fun clickHandler(view: View) {
        // setTextView()
        val data = etName.text.toString()
        val hIntent: Intent = Intent(this,HomeActivity::class.java);
        hIntent.putExtra("namekey",data)
        startActivity(hIntent)
    }

    private fun setTextView() {
        //get the data from edittext
        val name: String = etName.text.toString()
        //put that data into the textview
        tvRes.text = name
    }

}