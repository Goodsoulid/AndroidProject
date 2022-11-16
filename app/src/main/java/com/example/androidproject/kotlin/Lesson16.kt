package com.example.androidproject.kotlin

class Lesson16 {

    //val number: Int = null
    val name: String? = null


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val values = Values(0)

            println(values.name)
        }
    }
}
//проверка на null
data class Values(
    val number: Int,
    val name: String? = "have no string"
)