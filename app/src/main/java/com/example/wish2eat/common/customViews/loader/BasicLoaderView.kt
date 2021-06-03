package com.example.wish2eat.common.customViews.loader

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.wish2eat.R

class BasicLoaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        inflate(context, R.layout.basic_loader, this)
    }
}