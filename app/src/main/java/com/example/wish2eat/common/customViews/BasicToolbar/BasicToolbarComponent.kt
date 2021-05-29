package com.example.wish2eat.common.customViews.BasicToolbar

import android.view.View
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseActivity

class BasicToolbarComponent(wildActivity: BaseActivity): BasicToolbarComponentContract {
    private val basicToolbar: BasicToolbarView = wildActivity.findViewById(R.id.basic_toolbar)

    override fun setBackButtonBehavior(onClickListener: View.OnClickListener?) {
        basicToolbar.setBackButtonBehavior(onClickListener)
    }

    override fun setAccountButtonBehavior(onClickListener: View.OnClickListener?) {
        basicToolbar.setAccountButtonBehavior(onClickListener)
    }

    override fun changeVisibilityBackButton(visibility: Boolean) {
        basicToolbar.changeBackButtonVisibility(visibility)
    }
}