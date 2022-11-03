package com.example.androidproject

private const val ZERO = 0
fun outerFun(){
    print("I'm an outer fun")
}
open class Lesson15 {

    val country: String = "Belarus"
    var city = "Minsk"
    lateinit var address: String


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val kotlinClass = KotlinClass("Aryna ",100)
            val kotlinClass2 = KotlinClass("country","city","address")
            println("${kotlinClass2.city} ${kotlinClass2.country} ${kotlinClass2.address}")

            val string = kotlinClass.getNameAndAge()
            print(string)

            val lesson15 = Lesson15()
            lesson15.country
            lesson15.city = "Brest"
            lesson15.address = " ugolnaya"
            print("${lesson15.address}")

            lesson15.returnBoolean()
            outerFun()


        }
    }

    fun emptyFun(){
        print("I am an empty fun")
    }

    fun returnBoolean(): Boolean = true
}

class KotlinClass(val name: String, var age: Int): Parent(),Behavior {

    public var country: String = ""
    public var city:String = ""
    public var address:String = ""

    constructor() : this("", 1)

    constructor(country: String,city: String,
                address: String) : this(){
        this.country = country
        this.city = city
        this.address = address
    }

    fun getNameAndAge(): String{
        return "$name \n $age"
    }

    override fun getHairColor() {
        super.getHairColor()
    }

    override fun getEyeColor() {
        TODO("Not yet implemented")
    }
}



open class Parent{

    open fun getHairColor(){

    }

}

interface Behavior{

    fun getEyeColor()
}