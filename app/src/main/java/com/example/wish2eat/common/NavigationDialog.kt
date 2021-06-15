package com.example.wish2eat.common

interface NavigationDialog {
    fun toAccount()

    fun toMyFavoriteList()

    fun logout()
}

interface DialogProfilePhotoManagement{
    fun changePhoto()
}