package com.example.wish2eat.common.core.enum

import androidx.annotation.DrawableRes
import com.example.wish2eat.R

enum class StoreType(private val storeType:Int = 0, @DrawableRes val storeIcon: Int, val nameType:String) {
    ICE_CREAM_SHOP(1, R.drawable.ic_ice_cream, "Ice Cream Shop"),
    HAMBURGER_SHOP(2, R.drawable.ic_burguer, "Hamburger Shop"),
    PIZZA_SHOP(3, R.drawable.ic_pizza, "Pizza Shop");

    companion object{
        fun from(storeType: Int) = values().find { it.storeType == storeType } ?: HAMBURGER_SHOP
    }
}