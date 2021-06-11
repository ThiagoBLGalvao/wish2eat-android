package com.example.wish2eat.home

import android.content.Intent
import com.example.wish2eat.R
import com.example.wish2eat.common.BaseActivity
import com.example.wish2eat.common.core.model.UserModel
import com.example.wish2eat.home.presentation.dashboard.DashboardFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity: BaseActivity() {
    companion object{
        const val USER_LOGGED = "user_logged"
    }
    override val layoutResource: Int = R.layout.activity_home

    override fun initActivity() {
        initDashboard()
    }

    private fun initDashboard(){
        val fragment = DashboardFragment.newInstance(getEntity())

        targetingManager.replace(fragment, "dashboard_fragment")
    }

    fun getEntity() = intent.getParcelableExtra<UserModel>(USER_LOGGED)!!
}
