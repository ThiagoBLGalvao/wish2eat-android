package com.example.wish2eat.splashScreen

import android.content.Intent
import com.example.wish2eat.R
import com.example.wish2eat.account.AccountActivity
import com.example.wish2eat.common.BaseActivity
import com.example.wish2eat.home.HomeActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SplashActivity : BaseActivity(), SplashContract.View {
    override val layoutResource: Int = R.layout.activity_splash_screen

    private val presenter: SplashContract.Presenter by inject { parametersOf(this) }

    override fun initActivity() {
        presenter.verifyLoginState()
    }

    override fun openAccountActivity() {
        val i = Intent(this, AccountActivity::class.java)

        startActivity(i)
        finish()
    }

    override fun openHomeActivity() {
        openActivity(HomeActivity())
    }

    private fun openActivity(acitivity: BaseActivity) {
        val i = Intent(this, acitivity::class.java)

        startActivity(i)
        finish()
    }
}