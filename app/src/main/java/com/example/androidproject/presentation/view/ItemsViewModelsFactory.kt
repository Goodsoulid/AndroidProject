package com.example.androidproject.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidproject.domain.ItemsInteractor

class ItemsViewModelsFactory(private  val interactor: ItemsInteractor): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(interactor) as T
    }
}