package com.example.wish2eat.common.customViews.loader

import android.view.View
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseActivity

class BasicLoaderComponent(baseActivity: BaseActivity): LoaderContract {
    private val loaderView: BasicLoaderView = baseActivity.findViewById(R.id.basic_loader)

    override fun changeVisibility(state: Boolean) {
        if(state) loaderView.visibility = View.VISIBLE
        else loaderView.visibility = View.GONE
    }
}