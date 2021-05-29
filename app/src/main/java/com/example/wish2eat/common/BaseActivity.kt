package com.example.wish2eat.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wish2eat.R
import com.example.wish2eat.common.customViews.BasicToolbar.BasicToolbarComponent
import com.example.wish2eat.common.customViews.BasicToolbar.BasicToolbarComponentContract

abstract class BaseActivity: AppCompatActivity() {
    protected abstract val layoutResource: Int

    val containerId: Int = R.id.container_fragment

    open val basicToolbarComponent: BasicToolbarComponentContract by lazy { BasicToolbarComponent(this) }

    abstract fun initActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
        initActivity()
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount

        if(count == 0)
            super.onBackPressed()
        else
            supportFragmentManager.popBackStack()
    }
}