package com.example.androidproject.kotlin
//Обработка Null safety
class Lesson16Contin3 {

    //val number: Int = null
    val name: String? = null

    companion object{

        @JvmStatic
        fun main(args: Array<String>) {
            val values = Values(0)

            print(values.name)
        }
    }
}

data class Values(
    val number: Int,
    val name: String? = "have no string"
)