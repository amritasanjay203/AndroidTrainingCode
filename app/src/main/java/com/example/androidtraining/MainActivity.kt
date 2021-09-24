package com.example.androidtraining

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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
        when (view.id) {
            R.id.button -> {
                startHome()
            }
            R.id.buttonDial -> {
                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567")) //implicit intent
                startActivity(dialIntent)
            }
//            R.id.buttonAlarm -> {
//                createAlarm("Philips",17,15)
//            }
//            R.id.buttonMaps -> {
//                showMap(Uri.parse("geo:47.6,-122.3"))
//            }
        }

    }

    private fun startHome() {
//        val data = etName.text.toString()
        val hIntent: Intent = Intent(this, HomeActivity::class.java) // Explicit intent
//        hIntent.putExtra("namekey", data)
//        startActivity(hIntent)
        startActivityForResult(hIntent,123) //what is request code--123
        //for eg on whatsapp -- camera,contact, location the return point is onActivityREsult
    }

    private fun setTextView() {
        //get the data from edittext
        val name: String = etName.text.toString()
        //put that data into the textview
        tvRes.text = name
    }

//    fun clickClock(view: View) {
//        val clockIntent = Intent(Intent.ACTION_QUICK_CLOCK) // Implicit intent
//        startActivity(clockIntent)
//    }

//    fun createAlarm(message: String, hour: Int, minutes: Int) {
//        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
//            putExtra(AlarmClock.EXTRA_MESSAGE, message)
//            putExtra(AlarmClock.EXTRA_HOUR, hour)
//            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
//        }
//        if (intent.resolveActivity(packageManager) != null) {
//            startActivity(intent)
//        }
//    }
//
//    fun showMap(geoLocation: Uri) {
//        val intent = Intent(Intent.ACTION_VIEW).apply {
//            data = geoLocation
//        }
//        if (intent.resolveActivity(packageManager) != null) {
//            startActivity(intent)
//        }
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        //request code helps you determine from which childactivity[camera/contact] is returning the data
        //request code = 123, result code =RESULT_OK
        var data = intent?.getStringExtra("contactkey")
        tvRes.text = data
    }

}