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

            //3 способ
            nonNullableValue = nullableValue ?:0
            print(nullableValue)

            //4 способ
            nonNullableValue = nullableValue!!
            print(nullableValue)

            //5 способ проверки на null
            val outer = Outer(Inner("value in inner"))
            val value:String = outer.inner?.value ?: "" //обработка со значением по умолчанию


        }
    }
}

//5 способ проверки на null
data class Outer(val inner: Inner?)
data class Inner(val value:String)
