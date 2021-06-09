package com.example.wish2eat.account

import android.content.Intent
import com.example.wish2eat.R
import com.example.wish2eat.account.presentaion.login.LoginFragment
import com.example.wish2eat.common.BaseActivity
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.home.HomeActivity

class AccountActivity : BaseActivity()  {
    override val layoutResource: Int = R.layout.activity_account

    override fun initActivity() {
        val fragment = LoginFragment.newInstance(loginCallback = { loginCallback(it) })

        supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack("fragment_login")
            .commit()
    }

    private fun loginCallback(entity: UserModel){
        val i = Intent(this, HomeActivity::class.java)

        i.putExtra(HomeActivity.USER_LOGGED, entity)

        startActivity(i)
        finish()
    }
}