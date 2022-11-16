package com.example.androidproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.androidproject.MainActivity2.Companion.startMainActivity2

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToActivity2 = findViewById<Button>(R.id.btnGoToActivity2)

        btnGoToActivity2.setOnClickListener{
//            startActivity(
//
//                Intent(this, MainActivity2::class.java)
//                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                //MainActivity2 will not be added to the backstack
                // .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY) 2-ое активити не будет добавлено в историю
//            )
        }
        supportActionBar?.setBackgroundDrawable((ColorDrawable(resources.getColor(R.color.myColor))))
        supportActionBar?.title = "New title for MaiActivity"
        //supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.drawable.mypng))//добавляем  иконку в топбар


        val textView = findViewById<TextView>(R.id.textView)
        val btnCM = findViewById<Button>(R.id.btnCM)

        btnCM.setOnClickListener {
            textView.text = getString(R.string.hello_world)//показываем наш текствью при клике по кнопке
            startMainActivity2(this,
                textView.text.toString() + getString(R.string.from_mainActivity)
            )
        }

    }
}