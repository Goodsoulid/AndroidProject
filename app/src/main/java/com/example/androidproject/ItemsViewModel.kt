package com.example.androidproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidproject.model.ItemsModel
import com.google.android.material.navigation.NavigationView

class ItemsViewModel : ViewModel(){

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

     fun getData(){
         val listItems = listOf<ItemsModel>(
             ItemsModel(
                 R.drawable.android,
                 "Android",
                 "26.02.2023"

             ),
             ItemsModel(R.drawable.ios,
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
         _items.value = listItems
     }

    fun imageViewClicked(){
        _msg.value = R.string.Resurce
    }

    fun elementClicked(name: String, date: String, imageView: Int){
        _bundle.value = NavigateWithBundle(
            name = name,
            date = date,
            image = imageView
        )
    }

    fun userNavigated(){
        _bundle.value = null
    }

}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String,

)