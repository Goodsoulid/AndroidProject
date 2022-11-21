package com.example.androidproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.androidproject.kotlin.HausBuilder

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val lambda = //так выглядит лямбда "String" не обязательно
            { string: String -> Toast.makeText(
                this, "your test is $string",
                Toast.LENGTH_SHORT).show()
            }
        lambda("Set text in lambda")

        makeRequest("https://google.com/"){ callbackResult ->//использовали лямбду и переименовали "it"
            Log.w("callBack result", callbackResult)//лог результата
        }

        val btn_kotlin = findViewById<Button>(R.id.btnKotlin)

        val person = object {//это анонимный класс с именем и методом
        val name = "Gleb"
            fun develop(){
                Log.w("anonyme class", "call develop fun")
            }
        }

        val person2 = object: Developer {//имплементим интерфейс и переопределяем его метод
        val name = "Gleb"
            override fun develop() {//переопределяем метод интерфейса
                Log.w("anonyme class", "call develop fun Developer")
            }
        }

        val house = HausBuilder.Builder ////сломалась андроид студио, добавить
            .setStock(3)
            .setSwimpool(false)
            .build()

        btn_kotlin.setOnClickListener {
            Log.w("housbuilder", "${house.hasSwimpool()} ${house.howManyStocks()}")
            person.develop()//вызываем метод у анонимного класса
            person2.name
            person2.develop()
            callAnonymeClass(person2)
            callAnonymeClass(object : Developer{
                override fun develop() {
                    Log.w("anonym class", "called develop fun Developer ")
                }
            })
            Toast.makeText(this, person.name, Toast.LENGTH_SHORT).show()
        }


    }

//    fun get(): String {
//        return ""
//    }
//
//    fun get2() = ""

    private fun returnAnonymClass(string: String) = object {
        fun develop(){
            Log.w("anonym class", "called develop fun from returnType $string")
        }
    }

    fun callAnonymeClass(developer: Developer){
        developer.develop()
    }

    fun makeRequest(url: String, argForCallback: (string: String) -> Unit){
        argForCallback.invoke("callBackResult $url")
    }

    companion object {
        fun kotlinActivityStart(context: Context) {
            context.startActivity(Intent(context, KotlinActivity::class.java))
        }
    }
}

interface Developer{

    fun develop()
}