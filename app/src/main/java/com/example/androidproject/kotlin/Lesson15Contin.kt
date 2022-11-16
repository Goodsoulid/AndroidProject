package com.example.androidproject.kotlin

open class Lesson15Contin {

    companion object{
        @JvmStatic
        open fun main(args: Array<String>) {
            val first = First()
            val first2 = First()

            val second = Second
            val second2 = Second

            print("${first.hashCode()} ${first2.hashCode()}\n")
            print("${second.hashCode()} ${second2.hashCode()}")
        }
    }
}

class First{
    
    fun navigate(){
        println("navigating...")
    }
    
}
//синглтон
object Second{

}