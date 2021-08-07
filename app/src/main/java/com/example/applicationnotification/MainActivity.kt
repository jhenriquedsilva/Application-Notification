package com.example.applicationnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.send_notificaton_button)
        button.setOnClickListener {
            this.showNotification("1234", "Bootcamp Android", "Kotlin Android Course")
        }

        Log.i("newToken", FirebaseInstanceId.getInstance().token.toString())
    }
}