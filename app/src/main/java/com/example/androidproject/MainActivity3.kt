package com.example.androidproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btn = findViewById<Button>(R.id.btnGoToActivity1)

        btn.setOnClickListener {
            startActivity(
                Intent("com.example.androidproject.OPEN_ACTIVITY1")
            )
        }
    }
}
