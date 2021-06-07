package com.example.wish2eat.common.core.targeting

import androidx.fragment.app.FragmentTransaction
import com.example.wish2eat.common.BaseActivity
import com.example.wish2eat.common.BaseFragment

class TargetingManager(private val baseActivity: BaseActivity) {
    fun replace(baseFragment: BaseFragment, fragmentName: String? = null){
        baseActivity.apply {
            supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(containerId, baseFragment)
                .addToBackStack(fragmentName)
                .commit()
        }
    }
}