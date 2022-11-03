package com.example.androidproject

class Collect {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val collectionList = listOf<String>(
                "hello",
                "bye",
                "world"
            )
            //collectionList.add() we can;t to so

            //mutable collection
            val collectionList2 = mutableListOf<String>()
            collectionList2.add("hello")
            collectionList2.add("bye")
            collectionList2.add("world")

            collectionList.forEach{ words ->
                print("$words ")
            }

            for(i in 1..collectionList.size){
                print(i)
            }

            val arrayList = arrayListOf<String>(
                "hello",
                "bye",
                "world"
            )

            for (word in arrayList){
                print(word)
            }

            for(i in 10 downTo 1 step 2)
                print("$i")

            for (i in 1..10){
                if(i==2){
                    println("Hello world!")
                    continue
                }
                println(i)
            }

            println("\n")

            val collect = Collect()
            repeat(10){
                println(collect.getName())
            }
        }
    }

    fun getName(): String{
        return "Hello!!!!!"
    }
}