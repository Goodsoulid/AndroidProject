package com.example.androidproject.presentation.view.home

import com.example.androidproject.domain.auth.AuthInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var detailsView: DetailsView

    fun setView(detailsFragment: DetailsFragment){
        detailsView = detailsFragment
    }

    fun getArguments(name: String?, date: String?, imageView: Int) {
        detailsView.displayItemData(
            when (name.isNullOrEmpty()) {
                true -> "No data"
                false -> name
            },
            when (date.isNullOrEmpty()) {
                true -> "No date"
                false -> date
            },
            imageView)
    }

    fun logoutUser(){
        authInteractor.logoutUser()
        detailsView.userLoggedOut()
    }
}