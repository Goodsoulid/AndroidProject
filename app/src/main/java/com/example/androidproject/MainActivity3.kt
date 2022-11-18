package com.example.androidproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val editText = findViewById<EditText>(R.id.et_text)
        val editText2 = findViewById<EditText>(R.id.et_text2)

        val button = findViewById<Button>(R.id.btn_displayText)
        val textView = findViewById<TextView>(R.id.tv_text)

        val layout1 = findViewById<TextInputLayout>(R.id.textInputLayout)
        val layout2 = findViewById<TextInputLayout>(R.id.til)

        val rb1 = findViewById<RadioButton>(R.id.rb1)
        val rb2 = findViewById<RadioButton>(R.id.rb2)

        rb1.setOnClickListener {
            if (rb1.isChecked) {
                rb2.isChecked = false
            } else
                rb1.isChecked = true
        }

        rb2.setOnClickListener {
            if (rb2.isChecked) {
                rb1.isChecked = false
            } else
                rb2.isChecked = true
        }

        val dialog = AlertDialog.Builder(this)
            .setTitle("Information")
            .setMessage("I am android developer")
            .setCancelable(false)//нельзя закрыть сообщение, если нажать на экрран(нужно обязательно выбрать пункт)
            .setPositiveButton("OK"){dialog, _ ->
                Toast.makeText(this, "called positive", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){dialog, _ ->
                dialog.cancel()
            }

        button.setOnClickListener {
            dialog.show()

            if(editText.text.toString().isEmpty()){
                layout1.setErrorIconDrawable(R.drawable.ic_warning)
                editText.error = "name cant be empty"

            }else if(editText2.text.toString().isEmpty()){
                layout2.setErrorIconDrawable(R.drawable.ic_warning)
                editText2.error = "password cant be empty"
            }
        }
    }
}