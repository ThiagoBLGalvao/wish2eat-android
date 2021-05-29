package com.example.wish2eat.common.customViews.BottomButton

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.wish2eat.R
import kotlinx.android.synthetic.main.custom_view_bottom_button.view.*

class BottomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): FrameLayout(context, attrs, defStyleAttr) {
    init {
        inflate(context, R.layout.custom_view_bottom_button,this)
    }

    fun bindText(text:String){
        bottomButtonText.text = text
    }

    fun bindImage(imageResourceId: Int){
        bottomButtonImage.setImageResource(imageResourceId)
    }
}