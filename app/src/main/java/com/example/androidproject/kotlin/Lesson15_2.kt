package com.example.androidproject.kotlin

class Lesson15_2 {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val first2 = First2().navigate2()
            val second2 = First2.walk()
        }
    }
}

class First2{

    fun navigate2(){
        print("navigating...")
    }

    companion object{
        fun walk(){
            print("I'm walking")
        }
    }
}