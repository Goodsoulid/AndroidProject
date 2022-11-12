package com.example.androidproject.kotlin

class Lesson15Contin {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val first = First()
            val first2 = First()

            val second = Second
            val second2 = Second

            print("${first.hashCode()} ${first2.hashCode()}")
            println()
            print("${second.hashCode()} ${second2.hashCode()}")
        }
    }
}

open class First{

    fun navigate(){
        print("navigating...")
    }
}

object Second{

}

