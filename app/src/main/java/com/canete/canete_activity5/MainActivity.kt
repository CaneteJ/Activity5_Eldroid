package com.canete.canete_activity5

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navigateButton: Button = findViewById(R.id.navigateButton)
        navigateButton.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}