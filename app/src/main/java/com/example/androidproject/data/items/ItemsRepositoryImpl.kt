package com.example.androidproject.data.items

import com.example.androidproject.R
import com.example.androidproject.domain.items.ItemsRepository
import com.example.androidproject.model.ItemsModel
import javax.inject.Inject


class ItemsRepositoryImpl @Inject constructor(): ItemsRepository {

    override fun getData(): List<ItemsModel> {

        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.android,
                "Android",
                "26.02.2023"

            ),
            ItemsModel(
                R.drawable.ios,
                "Ios",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.flutter,
                "Flutter",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.xamarin,
                "Xamarin",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.banana,
                ".NET",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.banana,
                "C++",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.banana,
                "Goland",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.banana,
                "Ruby on Rains",
                "26.02.2023"
            ),
            ItemsModel(
                R.drawable.banana,
                "JS",
                "26.02.2023"
            ),
        )
        return listItems
    }

}