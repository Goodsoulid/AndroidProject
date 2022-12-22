package com.example.androidproject.presentation.view.home

import com.example.androidproject.model.ItemsModel

interface ItemsView {

    fun itemsReceive(itemsList: List<ItemsModel>)

    fun imageViewClicked(msg: String)

    fun itemsClicked(navigationData: NavigateWithBundle)
}