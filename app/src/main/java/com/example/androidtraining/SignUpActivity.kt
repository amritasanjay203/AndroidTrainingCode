package com.example.androidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView

class SignUpActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var etGivenName: EditText
    lateinit var placeSpinner: Spinner
    lateinit var display: TextView
    lateinit var submit: Button
    var place: String? = null
    var gender: String? = null
    var hobby: String? = null
    var places = arrayOf<String?>("Bangalore", "Mumbai",
        "Delhi", "Pune", "Cochin", "Chennai")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        etGivenName = findViewById(R.id.etEnterName)
        placeSpinner = findViewById(R.id.places_spinner)
        display = findViewById(R.id.tvDetails)
        submit = findViewById(R.id.submit)
        placeSpinner.onItemSelectedListener = this
        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            places)
        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)
        placeSpinner.adapter = ad
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        place = places[p2]
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_male ->
                    if (checked) {
                        gender = "Male"
                    }
                R.id.radio_female ->
                    if (checked) {
                        gender = "Female"
                    }
            }
        }
    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_swim -> {
                    if (checked) {
                        hobby = "Swim"
                    }
                }
                R.id.checkbox_read -> {
                    if (checked) {
                        hobby = "Read"
                    }
                }
                R.id.checkbox_tennis -> {
                    if (checked) {
                        hobby = "Tennis"
                    }
                }
            }
        }
    }

    fun onSubmitClick(view: View) {
        val name = etGivenName.text.toString()
        display.text = getString(R.string.display_msg, "$name $gender $place $hobby")
    }
}
