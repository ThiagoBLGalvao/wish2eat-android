package com.example.wish2eat.common.customViews.basicToolbar

import android.view.View

interface BasicToolbarComponentContract {
    fun setBackButtonBehavior(onClickListener: View.OnClickListener?)

    fun setAccountButtonBehavior(onClickListener: View.OnClickListener?)

    fun changeVisibilityBackButton(visibility: Boolean)
}