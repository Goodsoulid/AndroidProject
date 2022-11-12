package com.example.androidproject.kotlin

class Lesson15Contin2 {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val first = First().navigate()
            val second = First2.walk()
        }
    }
}

class First2{

    fun navigate(){
        print("navigating...")
    }

    companion object {
        fun walk(){
            print("I'm walking")
        }
    }
}