package com.example.wish2eat.account

import com.example.wish2eat.R
import com.example.wish2eat.account.presentaion.login.LoginFragment
import com.example.wish2eat.common.BaseActivity

class AccountActivity : BaseActivity()  {
    override val layoutResource: Int = R.layout.activity_account

    override fun initActivity() {
        val fragment = LoginFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack("fragment_login")
            .commit()
    }
}