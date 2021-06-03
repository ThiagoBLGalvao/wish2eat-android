package com.example.wish2eat.common.customViews.basicToolbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import com.example.wish2eat.R

class BasicToolbarView : FrameLayout {
    private val layoutResourceId = R.layout.basic_toolbar

    private val backButton by lazy { findViewById<ImageButton>(R.id.backButton) }

    private val accountButton by lazy { findViewById<ImageButton>(R.id.accountButton) }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        val componentView = LayoutInflater.from(context).inflate(layoutResourceId, null)
        addView(componentView)
    }

    fun setBackButtonBehavior(onClickListener: OnClickListener?){
        backButton.setOnClickListener(onClickListener)
    }

    fun setAccountButtonBehavior(onClickListener: OnClickListener?){
        accountButton.setOnClickListener(onClickListener)
    }

    fun changeBackButtonVisibility(visibility: Boolean){
        if(visibility)
            backButton.visibility = View.VISIBLE
        else backButton.visibility = View.GONE
    }
}