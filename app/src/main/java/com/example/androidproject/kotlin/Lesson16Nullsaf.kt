package com.example.androidproject.kotlin

class Lesson16Nullsaf {

    val nullable: Int? = null

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lesson16Nullsaf = Lesson16Nullsaf()
            var nonNullableValue: Int = 0 // не null переменная

            val nullableValue: Int? = lesson16Nullsaf.nullable//это null переменная

            //1 способ(Java способ(условно))
//            if (nullableValue != null) {//проверяем что не null переменная
//                nonNullableValue = nullableValue
//            }else{
//                nonNullableValue = nullableValue

            //2 способ проверки на Null(котлин способ)
            nullableValue?.let {
                nonNullableValue = it
            }

            //3 способ проверки на Null(Elvise Operator ?:)
            nonNullableValue = nullableValue ?: 0
            println(nonNullableValue)

            //4 способ проверки на Null
            nonNullableValue = nullableValue!!
            println(nonNullableValue)

            //5 способ проверки на Null (.?)
                val outer = Outer(Inner("value in inner"))
                val value = outer.inner?.value
               // val value1: String = outer.inner?.value?: ""//обработка со значением по умолчанию
        }
    }
}
//5 способ проверки на Null
data class Outer(val inner: Inner?)
data class Inner(val value: String)