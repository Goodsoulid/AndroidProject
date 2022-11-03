package com.example.androidproject

class DataClass {


    companion object {
        lateinit var wallet: Wallet

        @JvmStatic
        fun main(args: Array<String>) {
            val country1 = Country("Minsk", "Pyshkina")
            val country2 = Country2("Gomel", "Lenina")

            println(country1)//В data class уже переопределён toString
            println(country2)//а в обычном - нет

            println("_________________________")

            val dataClassEx = DataClass

            repeat(10) {
                val random = (1..2).random()

                if (random == 2) {
                    dataClassEx.wallet = Wallet.Dollar(10, 1)
                } else {
                    dataClassEx.wallet = Wallet.Euro(20, 1)
                }

                when (dataClassEx.wallet) {
                    is Wallet.Dollar -> {
                        println((dataClassEx.wallet as Wallet.Dollar).buy.toString() + "dollar")
                    }
                    is Wallet.Euro -> {
                        println((dataClassEx.wallet as Wallet.Euro).buy.toString() + "euro")
                    }
                }

                val wallet2: Wallet = Wallet.Dollar(10, 1)

                when (wallet2) {
                    is Wallet.Dollar -> {}
                    is Wallet.Euro -> {}
                }
            }
        }
    }
}

data class Country(val city: String, val address: String)

class Country2(val city: String, val address: String)

sealed class Wallet {

    data class Euro(val buy: Int, val sell: Int) : Wallet()

    data class Dollar(val buy: Int, val sell: Int) : Wallet()


}