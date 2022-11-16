package com.example.androidproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnGoToActivity3 = findViewById<Button>(R.id.btnGoToActivity3)

        btnGoToActivity3.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }

        val textView2 = findViewById<TextView>(R.id.textView2)

        val data: String = intent.getStringExtra(KEY) ?: "no data"
        textView2.text = data
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == android.R.id.home){
//            onBackPressed()
//        }
//        if (item.itemId == R.id.close){
//            finishAffinity()
//        }
//        if (item.itemId == R.id.goBack){
//            onBackPressed()
//        }
        when(item.itemId){
            android.R.id.home -> onBackPressed()
            R.id.close -> finishAffinity()
            R.id.goBack -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object{//для навигации всегда используем компаньон...

        private const val KEY = "1"//никаких захардкоженных значений

        fun startMainActivity2(
            context: Context,
            string: String
        ){
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY, string)
            context.startActivity(intent)
        }
    }
    // Выход из приложения через кнопку назад
//    override fun onBackPressed() {
//        super.onBackPressed()
//        finishAffinity()
//    }

}